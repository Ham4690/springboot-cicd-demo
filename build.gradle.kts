import net.ltgt.gradle.errorprone.CheckSeverity
import net.ltgt.gradle.errorprone.errorprone

plugins {
	java
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"
	id("net.ltgt.errorprone") version "4.0.1"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	// NullAway Setting
	errorprone("com.uber.nullaway:nullaway:0.11.1")
	compileOnly("org.jspecify:jspecify:1.0.0")
	errorprone("com.google.errorprone:error_prone_core:2.29.2")
}


tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<JavaCompile> {
	// テストコードに対してもNullAwayを実行したい場合はif条件を削除します
	if (!name.lowercase().contains("test")) {
		options.errorprone {
			check("NullAway", CheckSeverity.ERROR)
			option("NullAway:AnnotatedPackages", "com.example") // 解析対象のパッケージ名を適宜変更してください
		}
	}
}
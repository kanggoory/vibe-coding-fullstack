# 프로젝트 명세서 (Project Specification)

본 문서는 최소 기능 스프링부트 애플리케이션 'vibeapp'의 프로젝트 설정 및 명세를 정의합니다.

## 1. 프로젝트 설정 (Project Settings)

| 항목 | 상세 내용 |
| :--- | :--- |
| **JDK Version** | JDK 25 이상 |
| **Language** | Java |
| **Spring Boot** | 4.0.1 이상 |
| **Build Tool** | Gradle 9.3.0 이상 |
| **DSL** | Groovy DSL |
| **Configuration** | YAML (`application.yml`) |

## 2. 프로젝트 메타데이터 (Project Metadata)

| 항목 | 상세 내용 |
| :--- | :--- |
| **Group ID** | `com.example` |
| **Artifact ID** | `vibeapp` |
| **Main Class** | `com.example.vibeapp.VibeApp` |
| **Description** | 최소 기능 스프링부트 애플리케이션을 생성하는 프로젝트다. |

## 3. 빌드 구성 (Build Configuration)

### 플러그인 (Plugins)
- `org.springframework.boot` (version >= 4.0.1)
- `io.spring.dependency-management` (Spring Boot 버전에 맞춰 추가)
- `java`

### 의존성 (Dependencies)
- 현재 의존성 없음 (최소 기능 프로젝트)

## 4. 설정 파일 구성 (Configuration Files)
- 프로젝트 설정은 `src/main/resources/application.yml` 파일을 사용합니다.

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

- Thymeleaf (`spring-boot-starter-thymeleaf`)
- **[NEW]** Bootstrap 5.3.3 (via CDN)

## 4. 설정 파일 구성 (Configuration Files)
- 프로젝트 설정은 `src/main/resources/application.yml` 파일을 사용합니다.

## 5. Git 커밋 메시지 규약 (Git Commit Convention)
- `git-message-format.md` 파일에 정의된 **Conventional Commits** 형식을 따릅니다.
- **형식**: `<type>(<scope>): <subject>`
- **Type**: `feat`, `fix`, `refactor`, `docs`, `chore` 등

## 6. UI 프레임워크 및 템플릿 (UI Framework & Templates)
- **Bootstrap 5.3.3**: CDN 방식으로 적용되어 있습니다.
- **아이콘**: Material Symbols Outlined 사용
- **폰트**: Lexend Font
- **템플릿 구조**: 기능별 서브디렉토리로 구성 (`src/main/resources/templates/`)
  - `home/`: 메인 화면 관련 (`home.html`)
  - `post/`: 게시글 CRUD 관련 (`posts.html`, `post_detail.html` 등)

## 7. 아키텍처 및 패키지 구조 (Architecture & Package Structure)
- **기능 기반 패키지 구조 (Feature-oriented Package Structure)**: 계층(Layer)이 아닌 기능(Feature) 단위로 패키지를 구성합니다.
  - `com.example.vibeapp.home`: 홈 화면 관련 로직
  - `com.example.vibeapp.post`: 게시글 관련 로직 (Controller, Service, Repository, Entity)
- **명명 관례 (Naming Convention)**:
  - 엔티티 식별자는 `id`를 사용합니다.
  - 서비스 메서드는 `get{Entity}ById`, `create{Entity}` 등 행위 중심의 이름을 사용합니다.

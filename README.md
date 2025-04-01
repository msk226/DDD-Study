# DDD 기반 Q&A 플랫폼 설계 및 구현

본 프로젝트는 이전에 진행했던 프로젝트인 QP를 기반으로,  
**도메인 주도 설계(Domain-Driven Design, DDD)** 를 적용하여 구조화된 백엔드 아키텍처를 실습하고 구현한 결과입니다.

작성한 유즈케이스는 [`UseCase.md`](./UseCase.md) 파일을 참고해주세요.

---

## 📚 목차

1. [도메인 주도 설계를 적용하게 된 계기](#-도메인-주도-설계를-적용하게-된-계기)
2. [주요 설계 포인트](#-주요-설계-포인트)
3. [기술 스택](#-기술-스택)
4. [기능 구성](#-기능-구성)
5. [개발 흐름](#-개발-흐름)
6. [고민의 흔적들](#고민의-흔적들-)
7. [정리](#-정리)

---

## ✨ 도메인 주도 설계를 적용하게 된 계기

보다 **역할과 책임이 명확하게 분리되어 있고**,  
**비즈니스 로직이 코드 구조에 자연스럽게 녹아드는** 체계적인 코드를 작성하고 싶었습니다.

기존 MVC 중심 개발 방식에서 느낀 한계:
- 계층은 나뉘었지만, 도메인 규칙은 서비스에 분산되어 있음
- 도메인 모델이 단순한 데이터 덩어리로 전락
- 기능이 많아질수록 설계 의도와 책임이 불분명해짐

이러한 한계를 극복하기 위해 DDD 기반으로 코드를 리디자인하며 설계력을 훈련했습니다.

---

## 🧩 주요 설계 포인트

| 항목 | 설계 방향 |
|------|-----------|
| 계층 구조 | `domain`, `application`, `presentation`, `infrastructure` 명확히 분리 |
| 유즈케이스 중심 개발 | `UseCase` 인터페이스 기반으로 Command/Query 분리 |
| **Command 객체 분리** | Controller ↔ UseCase 간 명확한 계약을 위해 Command 클래스로 요청 값 래핑 |
| VO 사용 | `Email`, `Nickname`, `PhoneNumber`, `Title`, `Content` 등 불변 객체 설계 |
| 바운디드 컨텍스트 | User / Question / Answer 별도 책임으로 나눔 |
| Query 분리 (CQRS) | 조회는 DTO + QueryRepo로, 변경은 도메인 중심으로 처리 |
| 테스트/확장성 고려 | 의존성 낮춘 구조로 단위 테스트와 이벤트 확장이 쉬운 구조 설계 |

---

## ⚙️ 기술 스택

- Java 21
- Spring Boot 3.x
- Spring Security + JWT
- JPA + QueryDSL
- MySQL
- Swagger UI

---

## ✅ 기능 구성

- 회원 가입 / 로그인 (JWT 인증)
- 질문 등록 / 수정 / 삭제 / 페이징 조회
- 답변 등록 / 수정 / 삭제 / 좋아요
- 질문 좋아요 (토글)
- 각 기능별 유즈케이스 기반 설계

---

## 🧠 개발 흐름

1. 기능별 유즈케이스 정의
2. 유즈케이스 단위로 GitHub 이슈 생성
3. `Command`, `UseCase`, `Service` 단위로 로직 구현
4. 커밋 로그 예시:

```text
feat[UC-04]: Question 페이징 조회 유즈 케이스 엔드포인트 작성
```

---


## 고민의 흔적들 


작성 예정

---
💬 정리
DDD를 처음부터 완벽하게 적용하는 건 어려웠지만, 하나하나 구조를 명확히 하고 책임을 정리해가면서 왜 도메인 중심 설계가 유지보수성과 확장성에서 중요한지 몸소 느낄 수 있는 과정이었습니다.

📌 자세한 유즈케이스는`UseCase.md`, 코드와 흐름은 GitHub 이슈/PR 및 커밋 내역을 참고해주세요.

# Bringko Word Frequency Project

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

## 프로젝트 설명

**Bringko Word Frequency** 프로젝트는 웹 페이지에서 HTML을 추출하여 자바스크립트와 스타일 태그를 제거한 후 텍스트 데이터를 분석하여 단어 빈도수를 계산하는 REST API를 제공합니다. 이 API는 주어진 URL에서 텍스트를 추출한 뒤, 단어의 빈도수를 JSON 형식으로 반환합니다.

---

## 주요 기능

- **URL 텍스트 분석**: 입력된 URL에서 HTML 태그, 자바스크립트, 스타일 태그 등을 제거하고, 순수한 텍스트 데이터를 추출합니다.
- **단어 빈도수 계산**: 추출된 텍스트에서 단어의 사용 빈도수를 계산하여 반환합니다.
- **JSON 응답**: 계산된 단어 빈도수 결과를 JSON 형식으로 제공하여 다른 시스템과의 연동을 용이하게 합니다.

---

## 기술 스택

- **프레임워크**: Spring Boot 2.7.x
- **언어**: Java 11 이상
- **빌드 도구**: Maven

---

## 설치 가이드

### 1. 클론 및 프로젝트 설정

```bash
git clone https://github.com/bringko/word-frequency.git
cd word-frequency
```

### 2. Maven 의존성 설치

```bash
mvn install
```

### 3. 애플리케이션 실행

```bash
mvn spring-boot:run
```

---

## 사용 방법

### 1. URL로부터 단어 빈도수 분석

API 요청을 통해 특정 URL에서 단어 빈도수를 계산할 수 있습니다. 다음은 예시 API 호출 방법입니다.

**API 엔드포인트**: `/api/parse`

#### GET 요청 예시

```http
GET /api/parse?url=https://example.com
```

#### 응답 예시

```json
{
    "example": 10,
    "word": 5,
    "frequency": 3,
    "test": 2
}
```

---

## 기여 방법

1. 이 저장소를 포크합니다(Fork).
2. 새로운 브랜치를 만듭니다(`git checkout -b feature/새로운기능`).
3. 변경사항을 커밋합니다(`git commit -m 'Add 새로운기능'`).
4. 브랜치에 푸시합니다(`git push origin feature/새로운기능`).
5. Pull Request를 생성합니다.

---

## 라이선스

이 프로젝트는 [MIT 라이선스](LICENSE)를 따릅니다.

---

## 문의

궁금한 점이나 문제가 발생하면 아래 이메일로 문의 주세요.

- 이메일: winniee940124@gmail.com

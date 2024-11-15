# calender_JPA
---

## API 명세서

#### 1. 일정 생성 조회

+ 설명 : 일정 하나를 생성합니다
+ HTTP : POST
+ URL : localhost:8080/calenders
+ 상태 코드 : 200 OK
  ```
  {
      "id": 1,
      "username": "myoma",
      "title": "내용1",
      "contents": "제목1",
      "createAt": "2024-11-15T01:10:54.052219",
      "modifiedAt": "2024-11-15T01:10:54.052219"    
  }
  ```
+ 에러 코드 : 404 Not Found
  ```
  {
      "message" : "Resource does not exist on server"       
  }
  ```


#### 2. 전체 일정 조회

+ 설명 : 일정 전체를 조회합니다
+ HTTP : GET
+ URL : localhost:8080/calenders
+ 상태 코드 : 200 OK
  ```
  [
    {
        "id": 1,
        "username": "myoma",
        "title": "내용",
        "contents": "제목",
        "createAt": "2024-11-14T20:19:22.340539",
        "modifiedAt": "2024-11-14T20:19:22.340539"      
    },
    {
        "id": 2,
        "username": "myoma2",
        "title": "내용2",
        "contents": "제목2",
        "createAt": "2024-11-14T20:19:22.340539",
        "modifiedAt": "2024-11-14T20:19:22.340539" 
    }
  ]
  ```
+ 에러 코드 : 404 Not Found
  ```
  {
      "message" : "Resource does not exist on server"       
  }
  ``` 


#### 3. 일정 단건 조회

+ 설명 : 일정 단건을 조회합니다
+ HTTP : GET
+ URL : localhost:8080/calenders/{id}
+ 상태 코드 : 200 OK
  ```
  {
      "id": 2,
      "username": "myoma",
      "title": "내용2",
      "contents": "제목2",
      "createAt": "2024-11-14T20:19:24.947777",
      "modifiedAt": "2024-11-14T20:19:24.947777"    
  }
  ```
+ 오류 코드
+ 400 Red Request
```
{
   "errors": [
        {
        "param": "password",
        "value": 123,
        "error": "TypeError",
        "msg": "must be String"
        }
    ]
}
```
+ 404 Not Found
```
{
   "message" : "Resource does not exist on server"
}
```


#### 4. 일정 수정

+ 설명 : 일정을 수정합니다
+ HTTP : PATCH
+ URL : localhost:8080/calenders/{id}
+ RequestBody
```
{
{
    "title" : "수정된 제목",
    "contents" : "수정된 내용"
}
}
```
+ 상태 코드 : 200 OK
```
{
      "id": 2,
      "username": "myoma",
      "title": "수정된 제목",
      "contents": "수정된 내용",
      "createAt": "2024-11-14T20:19:24.947777",
      "modifiedAt": "2024-11-14T20:19:24.947777"  
}
```
+ 오류 코드
+ 400 Red Request
```
{
   "errors": [
        {
        "param": "password",
        "msg": "Password does not match"
        }
    ]
}
```


#### 5. 일정 삭제 

+ 설명 : 일정을 삭제합니다
+ HTTP : DELETE
+ URL : localhost:8080/calenders/{id}
+ 상태 코드 : 200 OK
```
{
    1
}
```
+ 오류 코드
+ 400 Red Request
```
{
   "errors": [
        {
        "param": "password",
        "msg": "Password does not match"
        }
    ]
}
```


#### 6. 유저 생성 

+ 설명 : 유저를 생성합니다.
+ HTTP : POST
+ URL : localhost:8080/users
+ 상태 코드 : 200 OK
```
{
    "username" : "myoma",
    "password" : "1234",
    "email" : "qwer@qwer.com"
}
```
+ 오류 코드
+ 400 Red Request
```
{
   "errors": [
        {
        "param": "password",
        "value": 123,
        "error": "TypeError",
        "msg": "must be String"
        }
    ]
}
```


#### 7. 특정 유저 조회

+ 설명 : 특정 유저를 조회합니다.
+ HTTP : GET
+ URL : localhost:8080/users/{id}
+ 상태 코드 : 200 OK
```
{
    "username": "myoma",
    "email": "qwer@qwer.com"
}
```
+ 오류 코드
+ 404 Not found
```
{
    "message" : "Resource does not exist on server"
}
```


#### 8. 유저 전체 조회

+ 설명 : 전체 유저를 조회합니다.
+ HTTP : GET
+ URL : localhost:8080/users
+ 상태 코드 : 200 OK
```
[
    {
        "id": 1,
        "username": "myoma",
        "email": "qwer@qwer.com"
    },
    {
        "id": 2,
        "username": "myoma2",
        "email": "qwer@qwer2.com"
    }
]
```
+ 오류 코드
+ 404 Not found
```
{
    "message" : "Resource does not exist on server"
}
```

#### 9. 유저 삭제

+ 설명 : 유저를 삭제합니다.
+ HTTP : DELETE
+ URL : localhost:8080/users/{id}
+ 상태 코드 : 200 OK
```
[
    1
]
```
+ 오류 코드
+ 404 Not found
```
{
    "message" : "Resource does not exist on server"
}
```



---

## ERD
![ERD_IMAGE](https://github.com/user-attachments/assets/86cc05a9-990c-48aa-84d8-84b8c004cc61) 


---

## SQL
![SQL_IMAGE](https://github.com/user-attachments/assets/2d4207e5-4a06-45ea-b7d2-9cb5507ec7d1)
![SQL_IMAGE2](https://github.com/user-attachments/assets/14005003-e696-4ee4-91da-1ebf0e4ad3e5)






---






## 1.프로젝트명 : Calender_JPA (일정 관리 앱)

---

## 2.프로젝트 설명
+ 유저를 생성, 조회, 삭제하며 일정을 작성하고 저장하고 수정, 삭제할 수 있는 일정 관리 프로그램
  + Lv_1 기능
    + 일정을 배열 형식으로 저장.
    + 일정 전체 조회
    + 일정 단건 조회
    + 작성자와 내용 수정 가능 (먼저 입력한 비밀번호가 일치해야 수정 가능)
    + 일정 삭제 가능 (먼저 입력한 비밀번호가 일치해야 수정 가능)
  + Lv_2 기능
    + 유저를 생성하여 배열 형식으로 저장
    + 유저 이름이 다르면 일정 생성 불가
    + 유저 단건 조회
    + 유저 전체 조회
    + 유저 삭제
    + 유저 생성 시 비밀번호 추가.


---

## 3.프로젝트 설치 및 실행 방법
+ JAVA IDEA 프로그램 설치, JAVA 설치
+ Spring IDEA 프로그램 설치
+ mysql DB 설치
+ postman 사용
+ 코드 클론 후 사용

---
   
## 4.프로젝트 사용 방법
+ 개인 DB 설정
+ 프로그램 실행 후 서버가 정상적으로 작동하는 지 확인
+ postman을 통해 URL 및 JSON 작성

---

## 5.참고자료
+ https://devmango.tistory.com/202
+ https://velog.io/@314_dev/Spring-Cookie-Session
+ https://innovation123.tistory.com/57
+ https://velog.io/@gmtmoney2357/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EC%BF%A0%ED%82%A4-%EC%84%B8%EC%85%98

---

+ Version : 1.0

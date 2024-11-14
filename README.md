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

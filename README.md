
## 상품 관리 및 주문 REST API

</br>

### 요구사항

#### 관리자
- 컨텐츠 상품 등록
- 컨텐츠 상품 삭제
- 컨텐츠 상품 전체 조회
- 컨텐츠 상품 상세 조회  
- 컨텐츠 상품 수정

</br>

#### 사용자
- 컨텐츠 상품 전체 조회
- 컨텐츠 상품 상세 조회  
- 상품 주문하기
- 구매 상품 조회하기
- 구매 상품 상세조회


</br>

### ERD

![image](/doc/상품주문ERD.png)

</br>

### 설계도 

![image](/doc/AZ_상품도메인.png)

</br>

### 작업 수행순서 

</br>

#### 상품 도메인

- [x] 컨텐츠 엔티티 및 타입을 위한 ENUM 생성
- [x] 컨텐츠 엔티티 값 전달 객체 (DTO) 구현

- [x] 컨텐츠 도메인에 대한 Reuest 객체 추가 및  컨텐츠 등록을 위한 정적 클래스 멤버 추가
- [x] 컨텐츠 도메인에 대한 Response 객체 추가 및 컨텐츠 디테일 정보를 위한 정적 클래스 멤버 추가


- [x] 컨텐츠 등록 REST Controller를 POST 메서드로 구현
- [x] 컨텐츠 등록 기능 Service, Repository 구현


- [ ] 컨텐츠 도메인에 대한 Response에 및 컨텐츠 요약 정보를 위한 정적 클래스 멤버 추가
- [ ] 컨턴츠 전체 조회 REST Controller를 Get 메서드로 구현
- [ ] 컨텐츠 전체조회 기능 Service, Repository 구현


- [ ] 컨턴츠 단일 조회 REST Controller를 Get 메서드로 아이디 기준 Path Variable로 구현
- [ ] 컨텐츠 아이디 기준 단일 조회 기능 Service, Repository 구현


- [ ] 컨텐츠 수정 REST Controller를 POST 메서드로 구현
- [ ] 컨텐츠 도메인에 대한 Reuest 객체에 수정을 위한 정적 클래스 멤버 추가
- [ ] 컨텐츠 수정  기능 Service, Repository 구현


- [ ] 컨턴츠 단일 삭제 REST Controller를 Get 메서드로 아이디 기준 Path Variable로 구현
- [ ] 컨텐츠 아이디 기준 단일 조회 기능 Service, Repository 구현


#### 사용자 도메인

- [ ] 사용자 엔티티 생성 값 전달 객체 (DTO) 구현
- [ ] 사용자 도메인에 대한 Reuest 객체 추가 및  컨텐츠 등록을 위한 정적 클래스 멤버 추가
- [ ] 사용자 도메인에 대한 Response 객체 추가 및 컨텐츠 디테일 정보를 위한 정적 클래스 멤버 추가
- [ ] 사용자 등록 REST Controller를 POST 메서드로 구현
- [ ] 사용자 등록 기능 Service, Repository 구현


#### 포켓 도메인


- [ ] 포캣 엔티티 생성 값 전달 객체 (DTO) 구현
- [ ] 포캣 도메인에 대한 Reuest 객체 추가 및  컨텐츠 등록을 위한 정적 클래스 멤버 추가
- [ ] 포캣 도메인에 대한 Response 객체 추가 및 컨텐츠 디테일 정보를 위한 정적 클래스 멤버 추가


- [ ] 포캣 등록 REST Controller를 POST 메서드로 구현
- [ ] 포캣 등록 기능 Service, Repository 구현


- [ ] 포캣 사용자 아이디별 조회 기능 REST Controller를 POST 메서드로 구현
- [ ] 포캣 사용자 아이디별 조회 기능 Service, Repository 구현


- [ ] 포캣 삭제 REST Controller를 get 메서드로 구현
- [ ] 포캣 삭제 기능 Service, Repository 구현


#### 주문 도메인

- [ ] 주문 엔티티 생성 값 전달 객체 (DTO) 구현
- [ ] 주문 아이템 엔티티 생성 값 전달 객체 (DTO) 구현
- [ ] 주문 도메인에 대한 Reuest 객체 추가
- [ ] 주문 도메인에 대한 Response 객체 추가 및 컨텐츠 디테일 정보를 위한 정적 클래스 멤버 추가

- [ ] 주문 등록 REST Controller를 POST 메서드로 구현
- [ ] 주문 등록 기능 Service, Repository 구현

- [ ] 주문 아이템 등록 기능 Service, Repository 구현
- [ ] 주문 등록시 주문아이템 등록 기능 Service를 호출하여 사용자 소유 목록을 저장함
- [ ] 주문 등록시 주문아이템 등록 기능 Service를 호출하여 사용자 소유 목록을 저장함

- [ ] 주문 시 포캣 등록 기능 Service를 호출하여 사용자 소유 목록을 저장함



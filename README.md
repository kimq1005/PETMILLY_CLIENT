# PETMILLY

🐶유기 동물 신고/임시 보호/잃어버린 반려 동물 제보 등 도움이 필요한 동물들을 지도 형태로 한 눈에 볼 수 있고 채팅으로 연락이 가능한 서비스입니다.

동물을 사랑하는 사람들이 많아도 동물들을 도와주는데 필요한 정보나 제대로 된 커뮤니케이션 서비스가 부족한 상황입니다.이를 해결하고자 지도를 활용하여 도움이 필요한 동물에 대한 정보를 한눈에 볼 수 있고, 채팅을 통해 간편하게 커뮤니케이션을 할 수 있는 서비스를 만들게 되었습니다.

<br>

# ⭐️주요 기능
* 지도를 통해 도움이 필요한 동물들의 정보를 확인할 수 있음(NaverMap).
  * 카테고리(임시보호처 , 입양, 실종, 이동봉사) 및 위치에 따른 클러스터링 생성 
* 도움이 필요한 동물에 대한 정보에 대한 게시물을 올릴 수 있음.(입양 공고, 임보처 구하기, 이동봉사, 실종신고)
* 게시물을 확인 한 이용자가 임보처 신청, 입양 신청 등을 할 수 있음
* 게시물을 올린 이용자와 신청자는 체팅을 통해 서로 대화하고, 임보처 신청이나 입양 신청 등을 처리할 수 있음.
* 프로필을 통해서 사용자가 올린 게시물 등 필요 정보 확인 가능.

<br>


# 🛠Tech Stack
* Kotlin
* JetPackComPose
* Dagger Hilt
* MVVM
* JetPack(LiveData, ViewModel)
* Retrofit2, OKHttp, Gson 
* Coroutine
* NaverMap
* Coil
<br>

# 🧑🏻‍💻Team
* llama - Android Devloper
* Jake - BackEnd Devloper
* Sera - UI/UX Designer & Product Manager

매주 수요일10시마다 회의를 진행하였으며 Jira를 통해 회고록을 작성했습니다.
<br>

# 📖배운점
* JetPackCompose을 사용해 보면서 편의성과 xml과의 차이점을 알 수 있었음.
* Dagger Hilt를 사용해 의존성 주입을 할 수 있었음.
* JetpackCompose의 Composable 함수 안에서 안전한 비동기 작업을 위해 LaunchedEffect을 사용해야 한다는 것을 알 수 있었음.
* NaevrMap을 AndroidView를 통해 구현할 수 있었음.
* form-data로 서버로 통신을 할 수 있었음.
* 외부 라이브러리(클러스터링 라이브러리)를 사용해보면서 라이브러리의 사용법과 편의성에 대해 알 수 있었음.
* Figma를 이용해서 UI를 만들 수 있었음.

# 🧐새로 시도해 본것들

* Jetpack Compose
  * Composable 함수의 재사용성이 높아 편리하게 UI를 작성할 수 있었음
  * XML과 달리, RecyclerView를 작성할 때 Adapter를 작성할 필요가 없어서 쉽게 RecyclerView를 만들 수 있었음.
  
  
  
* Dagger Hilt
  * @AndroidEntryPoint, @HiltViewModel 어노테이션을 사용하여 액티비티와 뷰모델에 의존성을 손쉽게 주입할 수 있었음
  * XML 레이아웃을 사용하는 경우 ,DI 설정을 위해 XML 파일과 코드를 번갈아 가며 작성해야 하는 불편함이 있지만, Dagger Hilt를 사용하면 UI 구현 코드 내에서 간단하게 DI 설정을 할 수 있어 코드의 가독성 및 간결성을 유지할 수 있었음.
 

<br>
 
  
  
  
 
 
 
 
# 📷스크린샷 및 구동영상
스크린샷이 많은 화면은 동영상으로 대체했습니다.


* 메인 화면 및 회원 가입
<img width="23%" src="https://user-images.githubusercontent.com/68366753/228754112-72359d6b-30aa-4b11-a32c-5afabd791e47.gif"/>


<br></br>


* 홈 화면(네이버 맵)

<img width="20%" src="https://user-images.githubusercontent.com/68366753/228773070-48148a99-f056-4d25-b513-b1071851d27c.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/228773600-412e2c01-f03e-45aa-ae73-03d317960651.png"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/228773805-f6984c1f-9020-4c0e-83be-afeea99bec99.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/228774364-63fd75e8-5e68-4b50-b043-f51313c33b47.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/228774534-e66fb1db-9055-4c78-93a7-5236f6142a6a.jpeg"/> 

<br></br>

* 이동봉사 구해요

<img width="20%" src="https://user-images.githubusercontent.com/68366753/229289679-5835baad-f741-4cad-8a58-32a781c79a35.gif"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/229085084-0e7869f4-b66a-4004-b733-6b1a57d94892.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/229085019-2676602f-34f9-4cc7-acc6-ea5f8ea6e650.jpeg"/> 


<br></br>

* 임보처 구해요

<img width="20%" src="https://user-images.githubusercontent.com/68366753/229336206-66813b32-d746-470e-921e-4d6706d583a4.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/229336418-2e96cb04-dc7a-4d39-bd0f-0ee21f301ec4.gif"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/229337131-ee80fea5-2dce-4553-a921-8a3b7e1973d0.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/229337195-c27fb95b-3350-4047-b48e-69036f66d3e9.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/229337166-c95347f7-57aa-44ce-a6b4-7de238f89a4a.jpeg"/>


<br></br>


* 우리아이 찾아요


 <img width="20%" src="https://user-images.githubusercontent.com/68366753/229334798-9f3eb491-c45b-40c8-a0f9-7da477e8e128.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/229334279-d095ced0-7e69-46eb-8856-0fd212604ed3.gif"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/229333925-80ef70d8-329f-4452-a49f-adf44f9afd0a.gif"/>

<br></br>


* 입양 공고(진행중)


<img width="20%" src="https://user-images.githubusercontent.com/68366753/229337797-50a578dd-9912-46e4-bfa1-6cbcbb73c798.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/229337807-4df509f1-672e-4abf-b728-4d320bd18bdd.jpeg"/>

<br></br>



* 채팅방(진행중)

<img width="20%" src="https://user-images.githubusercontent.com/68366753/228779416-05b8c8a6-6196-484a-a08a-c8f78932e5c1.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/228779427-95c02e04-440a-4c91-820f-c085a46aac6d.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/228779438-038bff54-bdf6-423b-969a-0d5320c3aa4f.jpeg"/> 









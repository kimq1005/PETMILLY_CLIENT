# PETMILLY

🐶유기 동물 신고/임시 보호/ 잃어버린 반려 동물 제보 등 도움이 필요한 동물들을 지도 형태로 한 눈에 볼 수 있고 채팅으로 연락이 가능한 서비스입니다.

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

<br>

# 📖배운점
* JetPackCompose을 사용해 보면서 편의성과 xml과의 차이점을 알 수 있었음.
* Dagger Hilt를 사용해 의존성 주입을 할 수 있었고 Dagger와의 차이점을 알 수 있었음.
* JetpackCompose의 Composable 함수 안에서 안전한 비동기 작업을 위해 LaunchedEffect을 사용해야 한다는 것을 알 수 있었음.
* NaevrMap을 AndroidView를 통해 구현할 수 있었음.
* form-data로 서버로 통신을 할 수 있었음.
* 외부 라이브러리(클러스터링 라이브러리)를 사용해보면서 라이브러리의 사용법과 편의성에 대해 알 수 있었음.
* Figma를 이용해서 UI를 만들 수 있었음.


  <br>
  
  
# 🧐새로 시도해 본것들

* JetpackCompose의 도입 


  JetpackCompose를 우아한 형제들이 주최하는 우아콘을 보고 처음 알게 되었습니다. JetPackCompose를 사용하면 기존 XML 개발 방식에 비해서 코드 감소, 빠른 개발 등을 할 수 있다는 이점을 알게 되어 이번 프로젝트에는 JeptpackCompose를 배워 적용 해보기로 했습니다. 프로젝트를 진행하면서, 가장 편했던 점은 RecyclerView를 생성할 때 Adapter와 ViewHolder 등을 만들 필요 없이 LazyColumn, LazyRow를 사용하여 쉽게 만들 수 있다는 점이었습니다. 그러나 XML과 달리 개발한 UI를 실시간으로 확인할 수 없어서 에뮬레이터나 실제 기기에서 직접 확인해야 한다는 단점이 있었습니다.
 
  <br>
 
* Dagger Hilt를 활용한 의존성 주입

  JetpackCompose을 공부하던중 Dagger Hilt와의 호환성이 뛰어나다는 것을 알게 되었습니다. 하지만 Dagger Hilt의 개념 자체를 이해하는 것이 어렵고 특히 프로젝트에 실제로 적용하는 것이 어려웠습니다. 공식 문서를 보았지만 이해가 되지 않아 여러 블로그 등 포스팅을 읽어가며 이해하고 적용해보았습니다. 기존에 사용해오던 Dagger의 기본 개념을 더욱 확실하게 숙지한 상태에서 Dagger Hilt를 적용했다면 더 손쉽게 만들 수 있었을 것이라는 후회가 들었습니다. 수많은 시행 착오 끝에 일관성 있는 패키지 구조를 유지하며, 데이터 관련 패키지(data)와 도메인 관련 패키지(domain)를 나누어 각각의 패키지에서 필요한 클래스들을 module 형태로 관리하고, 의존성 주입을 위한 인터페이스(repository)와 구현체(implementation)를 각각의 패키지에 생성하여 작성하였고, Activity와 ViewModel에 @AndroidEntryPoint, @Inject 어노테이션을 사용해 의존성을 주입할 수 있어서 수월하게 프로젝트를 진행할 수 있었습니다.
  
  
  <br>
  
  
 * 클러스터링을 위한 외부 라이브러리의 사용
 
    저희 서비스는 유기동물에 대한 정보를 지도에서 클러스터링 된 유기동물의 정보를 확인하는 것 입니다. 초기에는 클러스터링 기능을 직접 개발하려 했지만, 백엔드 개발자분의 조언을 받아서 외부 라이브러리를 사용하게 되었습니다. 외부 라이브러리를 적용하면서 빠르고 효율적인 개발을 할 수 있었습니다.
<br>
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

<img width="20%" src="https://user-images.githubusercontent.com/68366753/229336206-66813b32-d746-470e-921e-4d6706d583a4.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/231102217-12752bb9-bdaa-46ea-a66e-de98328bd886.gif"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/229337131-ee80fea5-2dce-4553-a921-8a3b7e1973d0.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/229337195-c27fb95b-3350-4047-b48e-69036f66d3e9.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/229337166-c95347f7-57aa-44ce-a6b4-7de238f89a4a.jpeg"/>


<br></br>

 
* 우리아이 찾아요


 <img width="20%" src="https://user-images.githubusercontent.com/68366753/229334798-9f3eb491-c45b-40c8-a0f9-7da477e8e128.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/229334279-d095ced0-7e69-46eb-8856-0fd212604ed3.gif"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/229333925-80ef70d8-329f-4452-a49f-adf44f9afd0a.gif"/>

<br></br>


* 입양 공고(진행중)


<img width="20%" src="https://user-images.githubusercontent.com/68366753/229337797-50a578dd-9912-46e4-bfa1-6cbcbb73c798.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/229337807-4df509f1-672e-4abf-b728-4d320bd18bdd.jpeg"/>

<br></br>



* 채팅방(진행중)

<img width="20%" src="https://user-images.githubusercontent.com/68366753/228779416-05b8c8a6-6196-484a-a08a-c8f78932e5c1.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/228779427-95c02e04-440a-4c91-820f-c085a46aac6d.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/228779438-038bff54-bdf6-423b-969a-0d5320c3aa4f.jpeg"/> 









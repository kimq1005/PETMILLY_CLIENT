# PETMILLY

🐶유기 동물 신고/임시 보호/잃어버린 반려 동물 제보 등 도움이 필요한 동물들을 지도 형태로 한 눈에 볼 수 있고 채팅으로 연락이 가능한 서비스입니다.

동물을 사랑하는 사람들이 많아도 동물들을 도와주는데 필요한 정보나 제대로 된 커뮤니케이션 서비스가 부족한 상황입니다.이를 해결하고자 지도를 활용하여 도움이 필요한 동물에 대한 정보를 한눈에 볼 수 있고, 채팅을 통해 간편하게 커뮤니케이션을 할 수 있는 서비스를 만들게 되었습니다.

# ⭐️주요 기능
* 지도를 통해 도움이 필요한 동물들의 정보를 확인할 수 있음.
* 도움이 필요한 동물에 대한 정보에 대한 게시물을 올릴 수 있음.(입양 공고, 임보처 구하기, 이동봉사, 실종신고)
* 게시물을 확인 한 이용자가 임보처 신청, 입양 신청 등을 할 수 있음
* 게시물을 올린 이용자와 신청자는 체팅을 통해 서로 대화하고, 임보처 신청이나 입양 신청 등을 처리할 수 있음.




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

# 🧑🏻‍💻Team
* llama - Android Devloper
* Jake - BackEnd Devloper
* Sera - UI/UX Designer & Product Manager

# 📖배운점
* JetPackCompose을 사용해 보면서 확실한 편의성과 xml과의 차이점을 알 수 있었음.
* Dagger Hilt가 JetpackCompose에 사용하기 좋은 DI임을 알 수 있었음.
* JetpackCompose의 Composable 함수 안에서 안전한 비동기 작업을 위해 LaunchedEffect을 사용해야 한다는 것을 알 수 있었음.
* 외부 라이브러리를 사용해보면서 라이브러리의 편의성에 대해 알 수 있었음.
* Figma를 이용해서 U/I를 만들 수 있었음.

# 🧐개선사항 및 깨달은 점

* **JetPack Compose의 안전한 비동기 작업**
 JetPack Compose로 개발중 뷰모델에서 함수를 호출하면 반복적으로 실행이 되는 현상이 생겼습니다. 이러이러한 이유였고 LaunchedEffect안에서 함수를 호출해서 해결했습니다.

* **보안 문제**

  서비스에 로그인을 할때 api 호출 및 재로그인시 accessToken과 refreshToken이 발급되는데 단순하게 MainApplication에 저장해놓았습니다. 하지만 MainApplication에 저장시 이러이러한 이유때문에 보안이 취약하다는 것을 깨달아서 , 다시 뭐시기를 했다
  
 
  
  
  
 
 
 
 
# 📷스크린샷 및 구동영상
스크린샷이 많은 화면은 동영상으로 대체했습니다.


* 메인 화면 및 회원 가입
<img width="23%" src="https://user-images.githubusercontent.com/68366753/228754112-72359d6b-30aa-4b11-a32c-5afabd791e47.gif"/>


<br></br>


* 홈 화면(네이버 맵)

<img width="20%" src="https://user-images.githubusercontent.com/68366753/228773070-48148a99-f056-4d25-b513-b1071851d27c.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/228773600-412e2c01-f03e-45aa-ae73-03d317960651.png"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/228773805-f6984c1f-9020-4c0e-83be-afeea99bec99.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/228774364-63fd75e8-5e68-4b50-b043-f51313c33b47.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/228774534-e66fb1db-9055-4c78-93a7-5236f6142a6a.jpeg"/> 

<br></br>
* 채팅방(진행중)


<img width="20%" src="https://user-images.githubusercontent.com/68366753/228779416-05b8c8a6-6196-484a-a08a-c8f78932e5c1.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/228779427-95c02e04-440a-4c91-820f-c085a46aac6d.jpeg"/> <img width="20%" src="https://user-images.githubusercontent.com/68366753/228779438-038bff54-bdf6-423b-969a-0d5320c3aa4f.jpeg"/> 


<!-- 
![KakaoTalk_Photo_2023-03-30-17-38-20 001](https://user-images.githubusercontent.com/68366753/228779416-05b8c8a6-6196-484a-a08a-c8f78932e5c1.jpeg)
![KakaoTalk_Photo_2023-03-30-17-38-21 002](https://user-images.githubusercontent.com/68366753/228779427-95c02e04-440a-4c91-820f-c085a46aac6d.jpeg)
![KakaoTalk_Photo_2023-03-30-17-38-21 003](https://user-images.githubusercontent.com/68366753/228779438-038bff54-bdf6-423b-969a-0d5320c3aa4f.jpeg) -->

* 임보처 구해요

* 이동봉사 구해요

* 입양 공고

* 실종 신고







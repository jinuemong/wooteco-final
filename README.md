# 우테코 최종 미션

### 피드백 분석

- 요구사항을 정확히 준수 (기능, 프로그래밍, 과제 진행)
- 커밋 메시지 의미있게 작성
- **[컨벤션]** 
  - 이름으로 의도 드러내기
    - 연속된 숫자를 덧붙이거나(a1, a2, ..., aN), 불용어(Info, Data, a, an, the) 사용 금지
    - **지나친 축약 금지**
  - if, for, while문 사이의 공백도 코딩 컨벤션이다.
  - 문맥 분리에 공백 사용하기 but 과도한 공백 금지 
  - 의도가 드러나지 않는 경우만 **주석 작성** 
- 코틀린에서 제공하는 API 적극 활용
  - 함수 구현 전에 기존에 존재하는 기능인지 확인 
  - 배열 대신 Kotlin Collection 활용 (List,Set,Map)
- README.md 상세히 작성 
  - 예외적인 상황도 기능 목록에 추가 
  - 기능을 구현하면서 문서를 업데이트 
- 구현 순서도 코딩 컨벤션
  ```
  class A {
    프로퍼티

    init 블록

    부 생성자

    메서드

    동반 객체
  }
  ```
- 한 함수가 한 가지 기능만 담당한다 
    - 여러 함수에서 중복되어 사용되어 있는 코드가 있다면 코드를 분리 
    - 15라인 이상 작성 금지
- 항상 예외 상황을 생각하자 
  - 예외 상황에 대한 처리 ! 

- **[테스트 코드]**
  - 테스트 코드 목적이 단순 기능 점검이 아닌 나의 코드 피드백도 가능 
  - 작은 단위 테스트부터 쪼개어 작성한다
  - 성공하는 케이스 뿐 아니라 예외에 대한 케이스도 테스트한다.
  - 테스트 코드도 코드이므로 리팩토링을 통한 개선이 필요하다.
  - 테스트를 위한 코드는 구현 코드에서 분리되어야 한다
    - 테스트를 위해 접근 제어자를 바꾸는 경우 (금지)
    - 테스트 코드에서만 사용되는 메서드 (금지)
  - 딘위 테스트하기 어려운 코드는 외부로 분리하는 시도를 한다
    - 아래의 코드는 테스트하기 어려운 코드다. (Randoms을 활용하기 어려움) 
    - `Randoms.pickUniqueNumbersInRange(1, 45, 6)`
    - 아래와 같이 외부로 분리한다.
    - `class Lotto(private val numbers: List<Int>)`

- 비즈니스 로직과 UI 로직을 분리한다
  - 단일 책임의 원칙에 위배하지 않도록 한다
- 연관성이 있는 상수는 전역 대신 enum 클래스를 활용한다
- 객체의 상태 접근을 제한한다
  ```
  class WinningLotto(
    private val lotto: Lotto,
    private val bonusNumber: Int
  )
  ```
- 객체는 객체스럽게 사용한다
  - 아래의 경우는 로직 구현 없이 외부로 객체를 드러내기만 한다 (잘못 된 경우 )
  ```
    class Lotto(private val numbers: List<Int>) {
       fun numbers() = numbers
    }
  ```
  - 데이터를 꺼내지 않고 던지는 구조를 활용한다.
  ```
  class Lotto(private val numbers: List<Int>) {
    fun contains(number: Int): Boolean {
       // 숫자가 포함되어 있는지 확인한다.
       return ...
    }

    fun matchCount(other: Lotto): Int {
       // 당첨 번호와 몇 개가 일치하는지 확인한다.
       return ...
    }
  }

  class LottoGame {
      fun play() {
      val lotto = Lotto(...)
      lotto.contains(number)
      lotto.matchCount(...)
      }
  }
  ```
- 필드의 수를 줄이기 위해 노력한다
  - 객체의 복잡도를 줄이고, 버그 발생 가능성을 낮출 수 있다.

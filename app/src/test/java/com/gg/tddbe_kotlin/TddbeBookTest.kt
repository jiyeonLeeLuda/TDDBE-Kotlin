package com.gg.tddbe_kotlin

import org.junit.Assert.*
import org.junit.Test

/** TDD by Example 화폐 예제
 * 1장
    <할일 목표>
     * $5 + 10CHF - 10$ (환율 2:1일 경우)
     * $5 x 2 = $10

     - 통화가 다른 두 금액을 더해서 주어진 환율에 맞게 변한 금액을 결과로 얻을 수 있어야 한다.
     - 어떤 금액(주가)을 어떤 수(주식의 수)에 곱한 금액을 결과로 얻을 수 있어야 한다.

 * 현재 집중하는 것 : 비교적 간단한 $5 x 2 = $10를 먼저 해결해보자.
 */
class TddbeBookTest {
    @Test
    fun testMultiplication() {
        var five = Dollar(5)
        five.times(2)
        assertEquals(10, five.amount)
    }
}

class Dollar(_amount:Int){

    var amount: Int = 0
    init {
        this.amount = _amount
    }
    fun times(_multiplier:Int){
        amount*=_multiplier
    }
}

/** 1장 끝
     <할일 목록>
     * $5 + 10CHF - 10$ (환율 2:1일 경우)
     v $5 x 2 = $10 /완료/
     * amount를 private으로 만들기
     * Dollar 부작용?
     * Money 반올림?

** 1장에서 한 일
    * 작업해야할 테스트 목록을 만들었다.
    * 오퍼레이션이 외부에서 어떻게 보이길 원하는지 말해주는 이야기를 코드로 표현했다.
    * 스텁 구현을 통해 테스트를 컴파일 했다.
    * 돌아가는 코드에서 상수를 변수로 변경하여 점진적으로 일반화 했다.
    * 새로운 할일들을 한번에 처리하는 대신 할일 목록에 추가하고 넘어갔다.
* */
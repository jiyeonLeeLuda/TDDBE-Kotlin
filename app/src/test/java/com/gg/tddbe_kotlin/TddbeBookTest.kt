package com.gg.tddbe_kotlin

import org.junit.Assert.*
import org.junit.Test

/** TDD by Example 화폐 예제
 * 2장
    <할일 목록>
     * $5 + 10CHF - 10$ (환율 2:1일 경우)
     v $5 x 2 = $10 /완료/
     * amount를 private으로 만들기
     * Dollar 부작용?
     * Money 반올림?

 * 현재 집중하는 것 : Dollar 부작용?
 */
class TddbeBookTest {
    /**
     * 1장 예제에서는 테스트를 통과했지만, 여러번 곱셈 계산을 하는 경우는 어떨까 ?
     * @see testMultiplication_faild 를 실행해보자.

     * five는 달러가격을 표현하는 값이고
     * product는 곱셈의 결과 이다.
     * */
    @Test
    fun testMultiplication_faild() {
        val five = Dollar(5)
        var product = five.times_old(2)

        assertEquals(10, product) //실재 값 10

        product= five.times_old(3)
        assertEquals(15, product) //실제 값 30 (오류)
    /* 이 테스트는 실패할 것이다. 왜냐하면 기존 로직대로 라면, five (Dollar)의 amount값이 영영 바뀌어 버기 때문이다.
    *  Dollar와 test 함수를 리팩토링 해보자.
    * */
    }

    @Test
    fun testMultiplication() {
        val five = Dollar(5)
        var product = five.times(2)

        assertEquals(10, product.amount)
        product = five.times(3)
        assertEquals(15, product.amount)
    }

}

class Dollar(_amount:Int){

    var amount: Int = 0
    init {
        this.amount = _amount
    }
    fun times(_multiplier:Int): Dollar{
        return Dollar(amount*_multiplier)
    }
    fun times_old(_multiplier:Int): Int {
        amount *= _multiplier
        return amount
    }
}

/** 2장 끝
     <할일 목록>
     * $5 + 10CHF - 10$ (환율 2:1일 경우)
     v $5 x 2 = $10 /완료/
     * amount를 private으로 만들기
     v Dollar 부작용?
     * Money 반올림?

** 2장에서 한 일
    * 설계상의 결함 (Dollar의 부작용)을 그 결함으로 인해 실패하는 테스트로 변환했다. : 곱셈을 여러번 하는 방식으로 검증하여 실패를 시켰다.
    * 스텁 구현으로 빠르게 컴파일을 통과하도록 만들었다.
    * 올바르다고 생각하는 코드를 입력하여 테스트를 통과했다.

 ** 사용한 기법
 * 가짜로 구현하기 : 상수를 반환하게 만들고, 진짜 코드를 얻을때 까지 단계적으로 상수를 변수로 바꾸어간다.
 * 명백한 구현 사용하기 : 실제구현을 코딩한다.

 ** 용어
 * 스텁 구현 (stub implementation)
    메서드의 서명부와 (반환값이 있을 경우) 반환 명령만 적는 식으로 해서,
    이 메서드를 호출하는 코드 (이 경우엔 테스트 코드)가 컴파일 될 수 있도록 껍데기만 만들어두는 것을 뜻한다.

* */
package com.ijktech

/**
  * Created by jamesk on 11/05/2017.
  */
object
LorenzAttractor {

  def main(Arguments:Array[String]): Unit ={

    def func(y:List[Double], t:Double):List[Double] =
      List(10.0*(y(1)-y(0)), -y(0)*y(2)+28.0*y(0)-y(1), y(0)*y(1)-(8.0/3.0)*y(2))

    println(numerical.odeint(func, List(1.0, 1.0, 1.0), 0.0, 1000.0, 0.0001, null))
  }

}

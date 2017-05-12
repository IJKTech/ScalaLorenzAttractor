package com.ijktech

import java.io.{BufferedWriter, File, FileWriter}

/**
  * Created by jamesk on 11/05/2017.
  */
object numerical {

  def odeint(f: (List[Double], Double) => List[Double], y:List[Double], tstart:Double, tend:Double, dt:Double, w:BufferedWriter): List[Double] = {

    def eulerMethod(): List[Double] =
      (y, f(y, tstart).map(x => x * dt)).zipped.map(_ + _)

    def getWriter(fileName:String):BufferedWriter =
      new BufferedWriter(new FileWriter(new File(fileName)))

    def writeData():Unit = {
      w.write(f"$tstart%.3f, ${y(0)}%.3f, ${y(1)}%.3f, ${y(2)}%.3f%n")
      w.flush()
    }

    def closeBuffer():Unit =
    {
      w.flush()
      w.close()
    }

    if ((w == null) && (tstart < tend)) odeint(f, eulerMethod(), tstart+dt, tend, dt, getWriter("lorenz.csv"))

    else if (tstart < tend) { writeData(); odeint(f, eulerMethod(), tstart+dt, tend, dt, w)}

    else y
  }
}

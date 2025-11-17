package THREE

import scala.scalajs.js.UndefOr

extension [A](udo: UndefOr[A])

  def foreach(f: A => Unit): Unit =
    udo match
      case _: Unit => ()
      case a       => f(a.asInstanceOf[A])

  def getOrElse[B >: A](default: => B): B =
    udo match
      case _: Unit => default
      case a       => a.asInstanceOf[B]

  def isDefined: Boolean =
    udo match
      case _: Unit => false
      case _       => true

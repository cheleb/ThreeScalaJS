package THREE

import scala.scalajs.js.UndefOr

extension [A](udo: UndefOr[A])

  inline def foreach_(f: A => Unit): Unit =
    inline udo match
      case a: A => f(a)
      case _    => ()

  inline def getOrElse_[B >: A](default: => B): B =
    inline udo match
      case a: A => a
      case _    => default

  inline def isDefined: Boolean =
    udo match
      case a: A => true
      case _    => false

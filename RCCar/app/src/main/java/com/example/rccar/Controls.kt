package com.example.rccar

sealed class Controls (var route : String)
{
    object Controller : Controls("Controller")
    object Left : Controls("Left")
    object Right : Controls("Right")
    object Forward : Controls("Forward")
    object Backward : Controls("Backward")

}

package org.sert2521.subsystems

import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.DigitalOutput
import edu.wpi.first.wpilibj2.command.SubsystemBase

//Not working
object IO : SubsystemBase() {
    private val DIO0 = DigitalOutput(0)
    private val DIO1 = DigitalOutput(1)
    private val DIO2 = DigitalOutput(2)
    private val DIO3 = DigitalOutput(3)

    fun buttonADown(): Boolean = DIO0.get()
    fun buttonBDown(): Boolean = DIO1.get()
    fun buttonCDown(): Boolean = DIO2.get()

    fun setGreenLED(on: Boolean) = DIO1.set(on)
    fun setRedLED(on: Boolean) = DIO2.set(on)
    fun setYellowLED(on: Boolean) = DIO3.set(on)
}
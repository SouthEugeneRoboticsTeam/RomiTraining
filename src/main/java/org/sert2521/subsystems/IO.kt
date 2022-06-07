package org.sert2521.subsystems

import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.DigitalOutput
import edu.wpi.first.wpilibj2.command.SubsystemBase

object IO : SubsystemBase() {
    private val DIO0 = DigitalInput(0)
    private val DIO1 = DigitalInput(1)
    private val DIO2 = DigitalOutput(2)
    private val DIO3 = DigitalOutput(3)

    fun buttonADown(): Boolean = DIO0.get()
    fun buttonBDown(): Boolean = DIO1.get()

    fun setRedLED(on: Boolean) = DIO2.set(on)
    fun setYellowLED(on: Boolean) = DIO3.set(on)
}
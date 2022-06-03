package org.sert2521.subsystems

import edu.wpi.first.wpilibj.Encoder
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import edu.wpi.first.wpilibj.motorcontrol.Spark
import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.sert2521.COUNTS_PER_REVOLUTION
import org.sert2521.WHEEL_DIAMETER

object Drivetrain : SubsystemBase() {
    private val leftMotor = Spark(0)
    private val rightMotor = Spark(1)

    private val leftEncoder = Encoder(4, 5)
    private val rightEncoder = Encoder(6, 7)

    private val diffDrive = DifferentialDrive(leftMotor, rightMotor)

    val leftDistance: Double
        get() = leftEncoder.distance
    val rightDistance: Double
        get() = rightEncoder.distance

    val leftSpeed: Double
        get() = leftEncoder.rate
    val rightSpeed: Double
        get() = rightEncoder.rate

    init {
        leftEncoder.distancePerPulse = Math.PI * WHEEL_DIAMETER / COUNTS_PER_REVOLUTION
        rightEncoder.distancePerPulse = Math.PI * WHEEL_DIAMETER / COUNTS_PER_REVOLUTION
        resetEncoders()
        rightMotor.inverted = true
    }

    fun arcadeDrive(xAxisSpeed: Double, zAxisRotate: Double) = diffDrive.arcadeDrive(xAxisSpeed, zAxisRotate)

    fun setWheelSpeeds(left: Double, right: Double) = diffDrive.tankDrive(left, right)

    private fun resetEncoders() {
        leftEncoder.reset()
        rightEncoder.reset()
    }
}
package org.sert2521.subsystems

import edu.wpi.first.wpilibj.Encoder
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import edu.wpi.first.wpilibj.motorcontrol.Spark
import edu.wpi.first.wpilibj2.command.SubsystemBase

// By making a subsystem an object, we ensure there is only ever one instance of it
object RomiDrivetrain : SubsystemBase()
{
    private const val COUNTS_PER_REVOLUTION = 1440.0
    private const val WHEEL_DIAMETER_INCH = 2.75591 // 70 mm

    // The Romi has the left and right motors set to PWM channels 0 and 1 respectively
    private val leftMotor = Spark(0)
    private val rightMotor = Spark(1)

    // The Romi has onboard encoders that are hardcoded to use DIO pins 4/5 and 6/7 for the left and right
    private val leftEncoder = Encoder(4, 5)
    private val rightEncoder = Encoder(6, 7)

    // Set up the differential drive controller
    private val diffDrive = DifferentialDrive(leftMotor, rightMotor)

    val leftDistanceInch: Double
        get() = leftEncoder.distance
    val rightDistanceInch: Double
        get() = rightEncoder.distance

    init
    {
        // Initialize the RomiDrivetrain.
        // Use inches as unit for encoder distances
        leftEncoder.distancePerPulse = Math.PI * WHEEL_DIAMETER_INCH / COUNTS_PER_REVOLUTION
        rightEncoder.distancePerPulse = Math.PI * WHEEL_DIAMETER_INCH / COUNTS_PER_REVOLUTION
        resetEncoders()
        // Invert right side since motor is flipped
        rightMotor.inverted = true
    }

    fun arcadeDrive(xAxisSpeed: Double, zAxisRotate: Double) = diffDrive.arcadeDrive(xAxisSpeed, zAxisRotate)

    fun resetEncoders()
    {
        leftEncoder.reset()
        rightEncoder.reset()
    }

    override fun periodic()
    {
        // This method will be called once per scheduler run
    }

    override fun simulationPeriodic()
    {
        // This method will be called once per scheduler run during simulation
    }
}
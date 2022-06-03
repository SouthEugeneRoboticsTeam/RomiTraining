package org.sert2521

import edu.wpi.first.wpilibj.TimedRobot
import org.sert2521.subsystems.Drivetrain
import org.sert2521.subsystems.IO

object Robot : TimedRobot() {
    override fun teleopPeriodic() {
        Drivetrain.setWheelSpeeds(0.5, -0.5)

        IO.setGreenLED(IO.buttonADown())
        IO.setRedLED(IO.buttonBDown())
        IO.setYellowLED(IO.buttonCDown())
    }
}
package org.sert2521.commands

import edu.wpi.first.wpilibj2.command.CommandBase
import org.sert2521.subsystems.RomiDrivetrain

/** An example command that uses the [RomiDrivetrain].  */
class ExampleCommand : CommandBase()
{
    init
    {
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(RomiDrivetrain)
    }

    override fun initialize()
    {
        // Called when the command is initially scheduled.
        // Here we show an example of calling a function on the RomiDrivetrain
        RomiDrivetrain.resetEncoders()
    }

    override fun execute()
    {
        // Called every time the scheduler runs while the command is scheduled.
    }

    override fun end(interrupted: Boolean)
    {
        // Called once the command ends or is interrupted.
    }

    override fun isFinished(): Boolean
    {
        // Returns true when the command should end.
        return false
    }
}

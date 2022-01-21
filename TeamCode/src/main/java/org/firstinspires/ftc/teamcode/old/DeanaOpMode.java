package org.firstinspires.ftc.teamcode.old;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Deana TeleOp", group="Experimenting")
public class DeanaOpMode extends OpMode {

    FourWheelDriveController driveController;

    @Override
    public void init() {
        driveController = new FourWheelDriveController(
                hardwareMap.dcMotor.get("left_front_motor"),
                hardwareMap.dcMotor.get("left_back_motor"),
                hardwareMap.dcMotor.get("right_front_motor"),
                hardwareMap.dcMotor.get("right_back_motor"),
                true
        );
    }
//nigga
    @Override
    public void loop() {
        driveController.setSidePower(FourWheelDriveController.SIDE_BOTH, 1);

        driveController.step();
    }
}

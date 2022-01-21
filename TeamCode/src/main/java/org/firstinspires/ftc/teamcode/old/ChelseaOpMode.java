package org.firstinspires.ftc.teamcode.old;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Chelsea TeleOp", group="Experimenting")
public class ChelseaOpMode extends OpMode {
    ChelseaDriveController driveController;

    double forward;
    double rotation;
    double x;
    double y;

    @Override
    public void init() {
        driveController = new ChelseaDriveController(
                hardwareMap.dcMotor.get("left_front_motor"),
                hardwareMap.dcMotor.get("left_back_motor"),
                hardwareMap.dcMotor.get("right_front_motor"),
                hardwareMap.dcMotor.get("right_back_motor"),
                true
        );
        telemetry.addData("Starting at",  "  %d : %d : %d : %d",
                driveController.lf.getCurrentPosition(),
                driveController.lb.getCurrentPosition(),
                driveController.rf.getCurrentPosition(),
                driveController.rb.getCurrentPosition()
        );
        telemetry.update();
    }

    @Override
    public void loop() {
        forward = gamepad1.right_trigger;
        rotation = gamepad1.right_stick_x;
        x = gamepad1.left_stick_x;
        y = gamepad1.left_stick_y;

        driveController.setPower(forward);
        driveController.setX(x);
        driveController.setY(y);
        driveController.setRotation(rotation);

        telemetry.addData("Power", forward);
        telemetry.addData("Rotation", rotation);

        driveController.step(telemetry);
    }
}

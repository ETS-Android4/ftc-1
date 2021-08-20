package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Chelsea TeleOp", group="Experimenting")
public class ChelseaOpMode extends OpMode {

    ChelseaDriveController driveController;

    double forward;
    double rotation;
    double strafe;

    @Override
    public void init() {
        driveController = new ChelseaDriveController(
                hardwareMap.dcMotor.get("left_front_motor"),
                hardwareMap.dcMotor.get("left_back_motor"),
                hardwareMap.dcMotor.get("right_front_motor"),
                hardwareMap.dcMotor.get("right_back_motor")
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
        forward = gamepad1.left_stick_y;
        rotation = gamepad1.right_stick_x;
        strafe = gamepad1.left_stick_x;

        driveController.setPower(forward);
        driveController.setStrafe(strafe);
        driveController.setRotation(rotation);

        telemetry.addData("Power", forward);
        telemetry.addData("Strafe", strafe);
        telemetry.addData("Rotation", rotation);

        driveController.step(telemetry);
    }
}

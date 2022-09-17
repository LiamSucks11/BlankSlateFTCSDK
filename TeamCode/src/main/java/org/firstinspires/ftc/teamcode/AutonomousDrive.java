
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@Autonomous(name="Autonomous Drive", group="Linear Opmode")
public class AutonomousDrive extends LinearOpMode {

    DcMotor motorFrontLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackLeft;
    DcMotor motorBackRight;

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    public void driveForTime (double power, long milliseconds) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= milliseconds) {
            motorBackLeft.setPower(power);
            motorBackRight.setPower(power);
            motorFrontLeft.setPower(power);
            motorFrontRight.setPower(power);
        }

    }

    @Override
    public void runOpMode() {
        motorFrontLeft = hardwareMap.get(DcMotor.class, "frontleft");
        motorFrontRight = hardwareMap.get(DcMotor.class, "frontright");
        motorBackLeft = hardwareMap.get(DcMotor.class, "backleft");
        motorBackRight = hardwareMap.get(DcMotor.class, "backright");

        motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFrontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBackRight.setDirection(DcMotorSimple.Direction.FORWARD);

        waitForStart();
        driveForTime(.5, 1000);
        sleep(400);
        driveForTime(.1,2000);
        sleep(3000);
        driveForTime(1, 500);


    }
}

/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="blueAutonomousShort", group="Linear OpMode")
public class blueAutonomousShortFinalApproach extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeftDrive = null;
    private DcMotor frontRightDrive = null;
    private DcMotor backLeftDrive = null;
    private DcMotor backRightDrive = null;
   // private DistanceSensor distanceSensor = null;
    double speed = 1.0;
    private DcMotor duckSpinner;


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        frontLeftDrive = hardwareMap.get(DcMotor.class, "frontLeftDrive");
        frontRightDrive = hardwareMap.get(DcMotor.class, "frontRightDrive");
        backLeftDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");
        backRightDrive = hardwareMap.get(DcMotor.class, "backRightDrive");
      //  distanceSensor = hardwareMap.get(DistanceSensor.class, "distanceSensor");
        duckSpinner = hardwareMap.get(DcMotor.class, "duckSpinner");
        int power = 1;
        frontRightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        //    duckSpinner = hardwareMap.get(DcMotor.class, "duckSpinner");

        backRightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        runtime.reset();
        double gearReduction = 20.15293;
        double countsPerRev = 288;
        double wheelCircumferenceMM = 75 * Math.PI;
        double driveCounts = (countsPerRev * gearReduction / wheelCircumferenceMM);
        int frontRightTarget = frontRightDrive.getCurrentPosition() + (int) (-9 * driveCounts);
        int frontLeftTarget = frontLeftDrive.getCurrentPosition() + (int) (9 * driveCounts);
        int backRightTarget = backRightDrive.getCurrentPosition() + (int) (9 * driveCounts);
        int backLeftTarget = backLeftDrive.getCurrentPosition() + (int) (-9 * driveCounts);

        frontRightDrive.setTargetPosition(frontRightTarget);
        frontLeftDrive.setTargetPosition(frontLeftTarget);
        backRightDrive.setTargetPosition(backRightTarget);
        backLeftDrive.setTargetPosition(backLeftTarget);

        frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRightDrive.setPower(power);
        frontLeftDrive.setPower(power);
        backRightDrive.setPower(power);
        backLeftDrive.setPower(power);

        while (opModeIsActive() && (frontRightDrive.isBusy() || frontLeftDrive.isBusy() || backLeftDrive.isBusy() || backRightDrive.isBusy())) {
        }
        frontRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightDrive.setPower(0);
        frontLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        backLeftDrive.setPower(0);

        int frontRightTarget2 = frontRightDrive.getCurrentPosition() + (int) (-10 * driveCounts);
        int frontLeftTarget2 = frontLeftDrive.getCurrentPosition() + (int) (-10 * driveCounts);
        int backRightTarget2 = backRightDrive.getCurrentPosition() + (int) (-10 * driveCounts);
        int backLeftTarget2 = backLeftDrive.getCurrentPosition() + (int) (-10 * driveCounts);

        frontRightDrive.setTargetPosition(frontRightTarget2);
        frontLeftDrive.setTargetPosition(frontLeftTarget2);
        backRightDrive.setTargetPosition(backRightTarget2);
        backLeftDrive.setTargetPosition(backLeftTarget2);

        frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRightDrive.setPower(0.75);
        frontLeftDrive.setPower(0.75);
        backRightDrive.setPower(0.75);
        backLeftDrive.setPower(0.75);

        while (opModeIsActive() && (frontRightDrive.isBusy() || frontLeftDrive.isBusy() || backLeftDrive.isBusy() || backRightDrive.isBusy())) {
        }

        frontRightDrive.setPower(0);
        frontLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        duckSpinner.setPower(1 * power);
        sleep(3000);           // Show the elapsed game time and wheel power.
        duckSpinner.setPower(0);
        int frontRightTarget3 = frontRightDrive.getCurrentPosition() + (int) (40 * driveCounts);
        int frontLeftTarget3 = frontLeftDrive.getCurrentPosition() + (int) (40 * driveCounts);
        int backRightTarget3 = backRightDrive.getCurrentPosition() + (int) (40 * driveCounts);
        int backLeftTarget3 = backLeftDrive.getCurrentPosition() + (int) (40 * driveCounts);

        frontRightDrive.setTargetPosition(frontRightTarget3);
        frontLeftDrive.setTargetPosition(frontLeftTarget3);
        backRightDrive.setTargetPosition(backRightTarget3);
        backLeftDrive.setTargetPosition(backLeftTarget3);

        frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRightDrive.setPower(power);
        frontLeftDrive.setPower(power);
        backRightDrive.setPower(power);
        backLeftDrive.setPower(power);

        while (opModeIsActive() && (frontRightDrive.isBusy() || frontLeftDrive.isBusy() || backLeftDrive.isBusy() || backRightDrive.isBusy())) {
        }
sleep(1000);
        int frontRightTarget4 = frontRightDrive.getCurrentPosition() + (int) (9 * driveCounts);
        int frontLeftTarget4 = frontLeftDrive.getCurrentPosition() + (int) (-9 * driveCounts);
        int backRightTarget4 = backRightDrive.getCurrentPosition() + (int) (-9 * driveCounts);
        int backLeftTarget4 = backLeftDrive.getCurrentPosition() + (int) (9 * driveCounts);

        frontRightDrive.setTargetPosition(frontRightTarget4);
        frontLeftDrive.setTargetPosition(frontLeftTarget4);
        backRightDrive.setTargetPosition(backRightTarget4);
        backLeftDrive.setTargetPosition(backLeftTarget4);

        frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRightDrive.setPower(power);
        frontLeftDrive.setPower(power);
        backRightDrive.setPower(power);
        backLeftDrive.setPower(power);

        while (opModeIsActive() && (frontRightDrive.isBusy() || frontLeftDrive.isBusy() || backLeftDrive.isBusy() || backRightDrive.isBusy())) {
        }

        int frontRightTarget5 = frontRightDrive.getCurrentPosition() + (int) (50 * driveCounts);
        int frontLeftTarget5 = frontLeftDrive.getCurrentPosition() + (int) (50 * driveCounts);
        int backRightTarget5 = backRightDrive.getCurrentPosition() + (int) (50 * driveCounts);
        int backLeftTarget5 = backLeftDrive.getCurrentPosition() + (int) (50 * driveCounts);

        frontRightDrive.setTargetPosition(frontRightTarget5);
        frontLeftDrive.setTargetPosition(frontLeftTarget5);
        backRightDrive.setTargetPosition(backRightTarget5);
        backLeftDrive.setTargetPosition(backLeftTarget5);

        frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRightDrive.setPower(power);
        frontLeftDrive.setPower(power);
        backRightDrive.setPower(power);
        backLeftDrive.setPower(power);

        while (opModeIsActive() && (frontRightDrive.isBusy() || frontLeftDrive.isBusy() || backLeftDrive.isBusy() || backRightDrive.isBusy())) {
        }

        telemetry.addData("Status", "Run Time: " + runtime.toString()); //Displays elapsed time on phone.
        telemetry.update();

    }
}
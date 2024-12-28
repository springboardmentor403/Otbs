package com.otbs.service;

import org.springframework.stereotype.Service;

import lombok.Getter;

@Getter
@Service
public class BillEmailService {
     private String senderEmail = "sivarajc357@gmail.com";
     private String senderPassword = "tihuoneubjpnvmty"; // Use App Password if 2FA is enabled
     // HTML content for the email body
     private String billCreating = "<!DOCTYPE html>"
     + "<html>"
     + "<head>"
     + "    <title>Bill Notification</title>"
     + "    <style>"
     + "        body {"
     + "            font-family: Arial, sans-serif;"
     + "            margin: 0;"
     + "            padding: 0;"
     + "            background-color: #f4f4f4;"
     + "        }"
     + "        .email-container {"
     + "            max-width: 600px;"
     + "            margin: 20px auto;"
     + "            background-color: #ffffff;"
     + "            border: 1px solid #e0e0e0;"
     + "            border-radius: 8px;"
     + "            overflow: hidden;"
     + "            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);"
     + "        }"
     + "        .header {"
     + "            background-color: #4CAF50;"
     + "            color: #ffffff;"
     + "            text-align: center;"
     + "            padding: 20px;"
     + "            font-size: 24px;"
     + "        }"
     + "        .content {"
     + "            padding: 20px;"
     + "            color: #333333;"
     + "        }"
     + "        .content p {"
     + "            margin: 10px 0;"
     + "            font-size: 16px;"
     + "            line-height: 1.5;"
     + "        }"
     + "        .bill-details {"
     + "            margin: 20px 0;"
     + "            border-collapse: collapse;"
     + "            width: 100%;"
     + "        }"
     + "        .bill-details th, .bill-details td {"
     + "            border: 1px solid #dddddd;"
     + "            text-align: left;"
     + "            padding: 8px;"
     + "        }"
     + "        .bill-details th {"
     + "            background-color: #f2f2f2;"
     + "        }"
     + "        .footer {"
     + "            background-color: #f2f2f2;"
     + "            color: #777777;"
     + "            text-align: center;"
     + "            padding: 15px;"
     + "            font-size: 12px;"
     + "        }"
     + "        .button {"
     + "            display: inline-block;"
     + "            margin: 20px auto;"
     + "            padding: 10px 20px;"
     + "            font-size: 16px;"
     + "            color: #ffffff;"
     + "            background-color: #4CAF50;"
     + "            text-decoration: none;"
     + "            border-radius: 5px;"
     + "            text-align: center;"
     + "        }"
     + "    </style>"
     + "</head>"
     + "<body>"
     + "    <div class=\"email-container\">"
     + "        <!-- Header -->"
     + "        <div class=\"header\">"
     + "            <strong>Your Bill Notification</strong>"
     + "        </div>"
     + "        <!-- Content -->"
     + "        <div class=\"content\">"
     + "            <p>Dear Customer,</p>"
     + "            <p>Please find below the details of your bill:</p>"
     + "            <!-- Bill Details Table -->"
     + "            <table class=\"bill-details\">"
     + "                <tr>"
     + "                    <th>Bill ID</th>"
     + "                    <td>{{billId}}</td>"
     + "                </tr>"
     + "                <tr>"
     + "                    <th>Bill Issued Date</th>"
     + "                    <td>{{issueDate}}</td>"
     + "                </tr>"
     + "                <tr>"
     + "                    <th>Plan Name</th>"
     + "                    <td>{{planName}}</td>"
     + "                </tr>"
     + "                <tr>"
     + "                    <th>Bill Cycle</th>"
     + "                    <td>{{billCycle}}</td>"
     + "                </tr>"
     + "                <tr>"
     + "                    <th>Usage</th>"
     + "                    <td>{{Usage}}</td>"
     + "                </tr>"
     + "                <tr>"
     + "                    <th>Total Charges</th>"
     + "                    <td>{{totalCharges}}</td>"
     + "                </tr>"
     + "                <tr>"
     + "                    <th>Tax</th>"
     + "                    <td>{{tax}}</td>"
     + "                </tr>"
     + "                <tr>"
     + "                    <th>Final Amount</th>"
     + "                    <td>{{finalAmount}}</td>"
     + "                </tr><br>"
     + "                <tr>"
     + "                    <th>Due Date</th>"
     + "                    <td>{{dueDate}}</td>"
     + "                </tr>"
     + "            </table>"
     + "            <!-- Payment Button -->"
     + "            <p style=\"text-align: center;\">"
     + "                <a href=\"{{paymentLink}}\" class=\"button\">Pay Now</a>"
     + "            </p>"
     + "            <p>If you have already paid this bill, please disregard this email.</p>"
     + "            <p>Thank you for choosing our services.</p>"
     + "        </div>"
     + "        <!-- Footer -->"
     + "        <div class=\"footer\">"
     + "            <p>&copy; 2024 Your Company Name. All Rights Reserved.</p>"
     + "            <p>Contact us: <a href=\"mailto:support@yourcompany.com\">support@yourcompany.com</a></p>"
     + "        </div>"
     + "    </div>"
     + "</body>"
     + "</html>";
}
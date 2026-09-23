# Task 5 — Social Engineering Attacks

## 1. Introduction

Social engineering is a cybersecurity technique in which an attacker deceives or manipulates a person into revealing sensitive information, performing an action, or providing unauthorized access. Instead of depending only on technical vulnerabilities, social engineering attacks target human behavior such as trust, curiosity, fear, urgency, authority, and the desire to help others.

NIST defines social engineering as an attempt to trick someone into revealing information such as a password that can be used to attack systems or networks. Social engineering can involve attackers pretending to be trusted individuals or organizations in order to gain the victim's confidence.

Social engineering is an important cybersecurity concern because even a well-protected technical environment can be affected if an employee is deceived into clicking a malicious link, opening an unsafe attachment, revealing credentials, or connecting an unknown device.

Common social engineering attacks include phishing, pretexting, baiting, and quid pro quo attacks.

---

# 2. Phishing

Phishing is a form of social engineering in which attackers use fraudulent communications or websites while pretending to be a trusted person or organization. The goal may be to obtain passwords, personal information, financial information, authentication information, or access to computer systems.

Phishing can be delivered through email, websites, phone calls, text messages, social media, and other communication platforms.

## 2.1 Spear Phishing

Spear phishing is a targeted form of phishing directed at a particular individual, organization, or group.

Unlike mass phishing campaigns, spear phishing messages are often customized using information about the target. The attacker may use the victim's name, job role, organization, or current activities to make the message appear legitimate.

### Example

An attacker researches an employee and discovers that the employee works in the finance department. The attacker sends an email pretending to be the company's manager and asks the employee to review an attached financial document.

The objective is to make the employee trust the message and interact with the malicious attachment or link.

MITRE ATT&CK identifies spearphishing as a targeted form of phishing and documents variants such as malicious attachments and malicious links.

---

## 2.2 Whaling

Whaling is a type of phishing that specifically targets high-profile individuals such as executives, senior managers, or other people who have access to valuable information.

The attacker may impersonate:

* A company executive
* A senior manager
* A business partner
* A lawyer
* A financial institution
* A government organization

### Example

An attacker sends an email pretending to be a company's CEO and requests that an employee urgently transfer money or provide confidential company information.

Because the request appears to come from a senior person, the employee may feel pressure to respond quickly.

CISA describes whaling as phishing targeted at a high-profile individual to steal sensitive or high-value information.

---

## 2.3 Vishing

Vishing means **voice phishing**.

Instead of using email or text messages, the attacker uses a phone call or other voice communication to manipulate the victim.

The attacker may pretend to be:

* Bank support
* IT support
* A government official
* A company employee
* A delivery company
* A technical service provider

### Example

An attacker calls an employee and claims to be from the company's IT department. The attacker says that the employee's account has a security problem and asks the employee to provide authentication information.

MITRE ATT&CK documents phishing through voice communication as a technique that can involve impersonation and creating urgency or alarm.

---

## 2.4 Smishing

Smishing means **SMS phishing**.

It uses text messages to persuade victims to click a link, download a file or application, or communicate with the attacker.

### Example

A victim receives an SMS saying:

> "Your delivery could not be completed. Confirm your address using this link."

The link may lead to a fraudulent website designed to collect personal or authentication information.

CISA describes smishing as phishing through text messages that can encourage victims to click links, download files or applications, or begin a conversation.

---

## 2.5 Phishing Case Study — RSA SecurID Incident

A well-known example of a targeted phishing attack occurred in 2011 and involved RSA, the security company behind SecurID authentication products.

Attackers sent targeted phishing emails to four employees of RSA's parent company, EMC. The emails contained a malicious attachment disguised as an Excel spreadsheet. One recipient opened the attachment, allowing the attackers to exploit a vulnerability and install a backdoor on the computer.

The attackers then used their access to move further into the network and steal information associated with RSA's SecurID authentication products. RSA subsequently replaced customer SecurID tokens.

### Attack flow

```text
Targeted phishing email
        ↓
Malicious attachment
        ↓
Employee opens attachment
        ↓
Vulnerability exploited
        ↓
Backdoor installed
        ↓
Attackers gain access
        ↓
Further network access
        ↓
Sensitive RSA-related information stolen
```

### Lesson from the incident

The incident demonstrates that a single successful phishing interaction can become an entry point into a larger organizational environment. Security awareness, email security controls, attachment protection, patching, and monitoring can help reduce this type of risk.

---

## 2.6 Phishing Prevention Recommendations

### 1. Security Awareness Training

Employees should receive regular security awareness training so they can recognize suspicious emails, links, attachments, phone calls, and messages.

Training should include realistic examples of:

* Urgent requests
* Suspicious links
* Unexpected attachments
* Fake login pages
* Impersonation attempts

MITRE ATT&CK identifies user training as a mitigation for phishing.

### 2. Verify Unexpected Requests

Employees should independently verify unusual requests involving:

* Passwords
* Money transfers
* Sensitive documents
* Authentication codes
* Account changes

For example, if an employee receives an urgent request from a manager, the employee can contact the manager through a known phone number or another trusted communication method.

### 3. Use Multi-Factor Authentication

Multi-factor authentication (MFA) provides an additional authentication factor beyond a password.

Even when a password is stolen, MFA can provide additional protection. Organizations should consider stronger, phishing-resistant authentication methods where appropriate.

CISA recommends MFA as part of protecting user accounts and highlights stronger authentication for high-value services.

### 4. Use Email and Web Security Controls

Organizations can use technical controls to reduce phishing risk.

Examples include:

* Spam filtering
* Malicious attachment scanning
* URL filtering
* Email authentication
* Sender verification
* Blocking dangerous attachment types
* Monitoring suspicious email activity

MITRE ATT&CK identifies antivirus/antimalware, network intrusion prevention, web-content restrictions, email authentication, and user training as phishing mitigations.

---

# 3. Pretexting

## 3.1 Definition

Pretexting is a social engineering technique in which an attacker creates a false story or identity to persuade a victim to provide information or perform an action.

The attacker establishes a believable scenario called a **pretext**.

The attacker may pretend to be:

* IT support
* A manager
* A bank employee
* A delivery worker
* A customer
* A government official
* A technical support employee

NIST provides examples of social engineering where an attacker establishes trust and pretends to be a trusted person, such as a system administrator making a telephone inquiry.

---

## 3.2 How Pretexting Works

A typical pretexting attack can follow these stages:

```text
Research target
      ↓
Create false identity
      ↓
Create believable story
      ↓
Contact victim
      ↓
Build trust
      ↓
Request information/action
      ↓
Use obtained information
```

### Example

An attacker contacts an employee and says:

> "I am from the IT department. We are performing an account security check."

The attacker then asks the employee to provide account information.

The false IT-support identity is the **pretext**.

---

## 3.3 Pretexting Case Study

A common pretexting scenario is an attacker impersonating technical support.

For example, an attacker may contact an employee and claim that a security problem has been detected on the employee's account. The attacker may request information to "verify" the account.

NIST's authentication guidance gives an example in which an attacker masquerades as a system administrator during a telephone inquiry and attempts to convince a subscriber to reveal an authenticator secret.

### Security lesson

Employees should not trust an identity simply because someone claims to represent IT, management, a bank, or another trusted organization.

Identity and requests should be verified using established organizational procedures.

---

## 3.4 Pretexting Prevention

### 1. Verify Identity

Employees should verify unexpected callers or requesters using trusted contact information rather than information provided by the requester.

### 2. Follow Organizational Procedures

Sensitive requests should follow established approval and verification procedures.

For example:

* Password resets
* Financial transactions
* Access changes
* Data requests
* Account recovery

should not be performed simply because someone claims to have authority.

### 3. Do Not Share Sensitive Information

Employees should never disclose passwords, authentication codes, or other sensitive information simply because a person claims to be an employee or administrator.

---

# 4. Baiting

Baiting is a social engineering technique that uses something attractive or interesting to persuade a person to perform an unsafe action.

The bait may take a physical or digital form.

Examples include:

* Unknown USB drives
* Free software
* Fake downloads
* Free offers
* Attractive documents
* Fake prizes

Baiting commonly exploits **curiosity, reward, or convenience**.

---

## 4.1 Physical Baiting

Physical baiting involves a physical object being used to attract the victim.

A common example is an unknown USB drive.

### Example

An attacker leaves USB drives in an organization's parking area. The USB drives may be labeled with a believable company name or an interesting file name.

An employee finds one and connects it to a company computer out of curiosity.

The USB device may contain malicious files that can compromise the computer.

CISA has documented a removable-media threat scenario in which attackers drop USB drives containing malware in a supply-chain organization's parking lot. The drives were labeled to appear related to the organization, and employees inserted them into computers.

### Attack flow

```text
Unknown USB device
        ↓
Employee finds device
        ↓
Curiosity develops
        ↓
Employee connects USB
        ↓
Malicious content is accessed
        ↓
Computer may become compromised
```

---

## 4.2 Digital Baiting

Digital baiting uses an attractive digital item to persuade a victim to download or open something.

Examples include:

* Fake free software
* Fake games
* Pirated applications
* Fake prizes
* Free downloads
* Malicious documents
* Fake browser updates

### Example

A user searches for free software and finds a website offering a "free premium version." The user downloads and installs the software without verifying the source.

The downloaded program may contain malware.

---

## 4.3 Baiting Case Study

CISA's threat scenario describes an attack involving removable media. Threat actors placed USB drives in the parking lot of a supply-chain organization. The drives were labeled with the organization's logo and contained files designed to look relevant to the organization's business.

Employees picked up the USB devices and inserted them into computers. CISA reports that, in the referenced study, 48% of the distributed USB drives were inserted into organizational computers. The scenario demonstrates how curiosity and apparent relevance can make physical baiting effective.

### Security lesson

Organizations should establish clear rules for removable media and educate employees not to connect unknown devices to company systems.

---

## 4.4 Baiting Prevention

### 1. Do Not Connect Unknown USB Devices

Employees should never connect an unknown USB device to an organization's computer.

Unknown removable media should be reported to the IT or security team.

### 2. Download Software Only From Trusted Sources

Users should obtain applications and software from official or approved sources.

They should avoid unknown websites offering suspicious free versions or unauthorized software.

### 3. Be Careful With Attractive Downloads

Free offers, prizes, urgent downloads, and unexpected files can be used as bait.

Employees should verify the source before downloading or opening files.

---

# 5. Quid Pro Quo

Quid pro quo is a social engineering technique based on an exchange.

The attacker offers a benefit, service, or assistance in exchange for information or an action from the victim.

The phrase **"quid pro quo"** means approximately **"something for something."**

### Example

An attacker calls an employee and pretends to be a technical support employee.

The attacker says:

> "I can fix the problem with your computer, but I need some account information first."

The attacker creates the expectation that the victim will receive a benefit in return for providing information.

### Attack flow

```text
Attacker offers assistance
        ↓
Victim expects a benefit
        ↓
Attacker requests information/action
        ↓
Victim provides information
        ↓
Attacker uses the information
```

### Prevention

Organizations can reduce this risk by:

* Verifying support personnel
* Using official IT support channels
* Never sharing passwords
* Following established procedures
* Reporting suspicious support requests

---

# 6. Comparison Table

| Attack Type    | Primary Target            | Psychological Lever         | Best Countermeasure         |
| -------------- | ------------------------- | --------------------------- | --------------------------- |
| Phishing       | Employees / users         | Trust and urgency           | Security awareness + MFA    |
| Spear Phishing | Specific individuals      | Personalization and trust   | Verification + training     |
| Whaling        | Executives / senior staff | Authority and urgency       | Independent verification    |
| Vishing        | Phone users               | Authority and pressure      | Verify caller identity      |
| Smishing       | Mobile users              | Urgency and curiosity       | Avoid suspicious links      |
| Pretexting     | Employees / individuals   | Trust and deception         | Identity verification       |
| Baiting        | Employees / users         | Curiosity and reward        | Avoid unknown devices/files |
| Quid Pro Quo   | Employees / users         | Reciprocity and helpfulness | Follow official procedures  |

Phishing is documented by MITRE ATT&CK as an initial-access technique, with spearphishing attachment, spearphishing link, spearphishing via service, and spearphishing voice represented as sub-techniques.

---

# 7. Employee Security Awareness Checklist

Employees should follow these basic security practices:

* [ ] Verify unexpected requests for passwords, authentication codes, money, or sensitive information.
* [ ] Do not click suspicious links or open unexpected attachments.
* [ ] Do not connect unknown USB devices or removable media to company computers.
* [ ] Use multi-factor authentication wherever available and appropriate.
* [ ] Report suspicious emails, phone calls, text messages, requests, and other social engineering attempts to the appropriate security or IT team.

Regular training and clear reporting procedures can help employees recognize and respond to social engineering attempts. MITRE ATT&CK identifies user training as a mitigation for phishing.

---

# 8. Conclusion

Social engineering attacks demonstrate that cybersecurity is not only a technical problem. Attackers can manipulate people through trust, urgency, authority, curiosity, fear, and the expectation of receiving a benefit.

The three main takeaways from this report are:

1. **Social engineering targets human behavior.**
   Attackers may use phishing, pretexting, baiting, or quid pro quo techniques to influence victims.

2. **Verification and security controls reduce risk.**
   Independent verification, employee awareness training, MFA, email security, and controlled use of removable media can reduce the likelihood and impact of attacks.

3. **Employees are an important part of organizational security.**
   Employees should avoid acting under pressure, verify unexpected requests, protect authentication information, and report suspicious activity.

A strong security program therefore combines technical controls with employee awareness, clear procedures, and continuous security education.

---

# 9. References

1. **National Institute of Standards and Technology (NIST) — Social Engineering Glossary**
   NIST Computer Security Resource Center.
   https://csrc.nist.gov/glossary/term/social_engineering

2. **National Institute of Standards and Technology (NIST) — Phishing Glossary**
   NIST Computer Security Resource Center.
   https://csrc.nist.gov/glossary/term/phishing

3. **Cybersecurity and Infrastructure Security Agency (CISA) — Phishing**
   CISA Phishing General Security Guidance.
   https://www.cisa.gov/sites/default/files/2024-02/Update%20to%20Phishing%20General%20Security%20Postcard_01.01.2024.pdf

4. **MITRE ATT&CK — Phishing (T1566)**
   Enterprise ATT&CK Knowledge Base.
   https://attack.mitre.org/techniques/T1566/

5. **MITRE ATT&CK — Spearphishing Attachment (T1566.001)**
   Enterprise ATT&CK Knowledge Base.
   https://attack.mitre.org/techniques/T1566/001/

6. **MITRE ATT&CK — Spearphishing Voice (T1566.004)**
   Enterprise ATT&CK Knowledge Base.
   https://attack.mitre.org/techniques/T1566/004/

7. **NIST — Digital Identity Guidelines: Authentication and Lifecycle Management**
   NIST Special Publication 800-63B.
   https://pages.nist.gov/800-63-3/sp800-63b.html

8. **SANS Institute — Social Engineering**
   SANS Reading Room.
   https://www.sans.org/white-papers/1365/

9. **Wired — RSA SecurID Breach / Targeted Phishing Incident**
   Wired, reporting on the 2011 RSA incident.

10. **CISA — Removable Media Threat Scenario**
    CISA Threat Evaluation Working Group, Threat Scenarios.

---

## Ethical Use

This report is intended for cybersecurity education and awareness. The techniques described are documented to help recognize and prevent social engineering attacks. No real-world person, organization, account, device, or network should be targeted without explicit authorization.

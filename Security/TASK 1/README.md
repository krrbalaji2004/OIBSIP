# Task 1 – Basic Network Scanning with Nmap

## Objective

Perform a network scan on my own Windows 11 machine using Nmap to identify open ports, running services, and the operating system.

## What is Nmap?

Nmap (Network Mapper) is a network scanning and security auditing tool. It can discover hosts, identify open ports, detect services and versions, and perform operating system detection.

## Why Network Scanning Matters

Network scanning helps identify services that are accessible through a network. Security professionals can use this information to understand the attack surface of a system and identify services that should be restricted, secured, or updated.

## Tools Used

* Nmap 7.991
* Windows 11
* VS Code Terminal

## Target

The scan was performed only on my own local Windows 11 computer.

**Target IP:** `192.168.1.38`

No external, public, production, or unauthorized systems were scanned.

## Installation

Nmap was installed on Windows and verified using:

```bash
nmap --version
```

The installed version was:

```text
Nmap version 7.991
```

## Scans Performed

### 1. Basic Network Scan

Command:

```bash
nmap 192.168.1.38
```

The scan identified the following open TCP ports:

| Port      | Service      |
| --------- | ------------ |
| 135/tcp   | MSRPC        |
| 139/tcp   | NetBIOS-SSN  |
| 445/tcp   | Microsoft-DS |
| 16992/tcp | AMT-HTTP     |

The scan reported 996 closed TCP ports.

### 2. Service Version Scan

Command:

```bash
nmap -sV 192.168.1.38
```

Results:

| Port      | Service      | Detected Information                      |
| --------- | ------------ | ----------------------------------------- |
| 135/tcp   | MSRPC        | Microsoft Windows RPC                     |
| 139/tcp   | NetBIOS-SSN  | Microsoft Windows NetBIOS Session Service |
| 445/tcp   | Microsoft-DS | Service identification uncertain          |
| 16992/tcp | AMT-HTTP     | Service identification uncertain          |

Nmap identified the operating system family as Windows.

### 3. OS Detection

Command:

```bash
nmap -O 192.168.1.38
```

Nmap detected:

* Device type: General purpose
* Operating System: Microsoft Windows 11
* OS details: Microsoft Windows 11 24H2 - 25H2
* Network distance: 0 hops

## Open Port Security Analysis

### Port 135 – MSRPC

MSRPC is used by Windows for communication between applications and network services.

If unnecessarily exposed to untrusted networks, it can increase the system's network attack surface.

### Port 139 – NetBIOS-SSN

NetBIOS Session Service supports Windows network communication and older file/printer sharing mechanisms.

It should generally be restricted to trusted networks when it is not required.

### Port 445 – Microsoft-DS / SMB

Port 445 is commonly used by Windows for SMB file and printer sharing.

Improperly exposed or outdated SMB services can create security risks. Access should be restricted to trusted networks and systems should be kept updated.

### Port 16992 – Intel AMT HTTP

Port 16992 can be associated with Intel Active Management Technology (AMT) management services.

Management interfaces should be protected and accessible only to authorized users and trusted networks.

## Screenshots

### Basic Scan

![Basic Nmap Scan](screenshots/basic-scan.png)

### Service Version Scan

![Service Version Scan](screenshots/service-version-scan.png)

### OS Detection

![OS Detection Scan](screenshots/os-detection.png)

## Ethical Use

Nmap should only be used on systems that I own or have explicit permission to test.

For this project, all scanning was performed against my own local Windows 11 machine.

External websites, public IP addresses, company networks, college networks, and other unauthorized systems were not scanned.

## Conclusion

The Nmap scans identified four open TCP ports on the local Windows 11 machine: 135, 139, 445, and 16992.

The scans also provided service information and identified the operating system as Microsoft Windows 11.

This task demonstrated how Nmap can be used for basic network discovery, service identification, and security analysis in an authorized environment.

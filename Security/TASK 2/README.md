# Task 2 – Basic Firewall Configuration with UFW

## Objective

The objective of this task is to configure a basic firewall using **UFW (Uncomplicated Firewall)** on Ubuntu. The firewall is used to control incoming and outgoing network traffic based on defined rules.

## Tools Used

* Ubuntu Linux
* WSL (Windows Subsystem for Linux)
* UFW (Uncomplicated Firewall)
* VS Code
* Linux Terminal

## What is UFW?

UFW stands for **Uncomplicated Firewall**. It is a command-line firewall management tool available on Ubuntu and other Linux distributions.

UFW provides a simple way to allow or deny network traffic using firewall rules.

## Why is a Firewall Important?

A firewall helps protect a computer by controlling network connections.

It can:

* Block unwanted incoming connections
* Allow required services
* Reduce the network attack surface
* Control access to specific ports
* Improve basic system security

## Installation

The package list was updated using:

```bash
sudo apt update
```

UFW was installed using:

```bash
sudo apt install ufw
```

## Firewall Configuration

### 1. Default Incoming Policy

All incoming connections are denied by default:

```bash
sudo ufw default deny incoming
```

### 2. Default Outgoing Policy

Outgoing connections are allowed by default:

```bash
sudo ufw default allow outgoing
```

### 3. Allow SSH

SSH was allowed because it is commonly used for remote administration:

```bash
sudo ufw allow ssh
```

This allows traffic on port **22**.

### 4. Deny HTTP

HTTP traffic was denied:

```bash
sudo ufw deny http
```

This blocks traffic on port **80**.

### 5. Allow HTTPS

HTTPS traffic was allowed:

```bash
sudo ufw allow https
```

This allows traffic on port **443**.

### 6. Allow DNS

DNS traffic was allowed:

```bash
sudo ufw allow 53
```

Port **53** is commonly used for DNS services.

## Firewall Status

The firewall was enabled using:

```bash
sudo ufw enable
```

The configuration was verified using:

```bash
sudo ufw status verbose
```

### Final Configuration

| Port | Service | Action | Purpose                       |
| ---- | ------- | ------ | ----------------------------- |
| 22   | SSH     | ALLOW  | Remote administration         |
| 80   | HTTP    | DENY   | Block unencrypted web traffic |
| 443  | HTTPS   | ALLOW  | Secure web traffic            |
| 53   | DNS     | ALLOW  | Domain name resolution        |

## Final UFW Status

The final firewall status showed:

```text
Status: active
Logging: on (low)
Default: deny (incoming), allow (outgoing), disabled (routed)
```

The configured rules were:

```text
22/tcp    ALLOW IN    Anywhere
80/tcp    DENY IN     Anywhere
443       ALLOW IN    Anywhere
53        ALLOW IN    Anywhere
```

IPv6 rules were also automatically created by UFW.

## Script

The firewall configuration was automated using:

```text
ufw_configuration.sh
```

The script performs the following tasks:

1. Updates the package list
2. Installs UFW
3. Sets default incoming/outgoing policies
4. Allows SSH
5. Denies HTTP
6. Allows HTTPS
7. Allows DNS
8. Enables UFW
9. Displays the firewall status

## Security Considerations

Firewall rules should follow the principle of allowing only required services.

* SSH should be restricted to trusted systems when possible.
* Unnecessary ports should remain blocked.
* Firewall rules should be reviewed regularly.
* Systems should be kept updated.
* Firewall configuration should be tested after changes.

## Screenshot

The `screenshots` folder contains the final UFW status screenshot.

```text
screenshots/
└── ufw-status.png
```

## Ethical Use

This firewall configuration was performed on my own local Ubuntu environment for educational purposes.

Security tools and firewall configurations should only be used on systems that you own or have explicit authorization to test.

## Conclusion

UFW was successfully installed and configured on Ubuntu. The firewall was enabled with a default-deny incoming policy, while required services such as SSH, HTTPS, and DNS were allowed. HTTP traffic was explicitly denied. The final configuration was verified using `ufw status verbose`.

window.addEventListener('load', () => {
    const loader = document.getElementById('loader');

    loader.style.opacity = '0';

    setTimeout(() => loader.style.display = 'none', 500);
});

const cursor = document.querySelector('.custom-cursor');
document.addEventListener('mousemove', (e) => {
    cursor.style.left = e.clientX + 'px';
    cursor.style.top = e.clientY + 'px';
});

document.querySelectorAll('a, button, .glass-card').forEach(elem => {
    elem.addEventListener('mouseenter', () => cursor.style.transform = 'translate(-50%, -50%) scale(1.5)');
    elem.addEventListener('mouseleave', () => cursor.style.transform = 'translate(-50%, -50%) scale(1)');
});

window.addEventListener('scroll', () => {
    const winScroll = document.documentElement.scrollTop;
    const height = document.documentElement.scrollHeight - document.documentElement.clientHeight;
    const scrolled = (winScroll / height) * 100;
    document.getElementById('scroll-progress').style.width = scrolled + '%';
    const header = document.querySelector('.header');
    header.classList.toggle('sticky', window.scrollY > 100);
    const btt = document.getElementById('back-to-top');
    btt.classList.toggle('show', window.scrollY > 500);
    const sections = document.querySelectorAll('section');
    const navLinks = document.querySelectorAll('.navbar a');
    sections.forEach(sec => {
        const top = window.scrollY;
        const offset = sec.offsetTop - 150;
        const height = sec.offsetHeight;
        const id = sec.getAttribute('id');

        if(top >= offset && top < offset + height) {
            navLinks.forEach(links => {
                links.classList.remove('active');
                document.querySelector('.navbar a[href*=' + id + ']').classList.add('active');
            });
            if(id === 'skills') {
                document.querySelectorAll('.progress-bar span').forEach(span => {
                    span.style.width = span.style.getPropertyValue('--progress');
                });
            }
        }
    });
});
document.getElementById('back-to-top').addEventListener('click', () => {
    window.scrollTo({ top: 0, behavior: 'smooth' });
});
const themeToggle = document.getElementById('theme-toggle');
themeToggle.addEventListener('click', () => {
    const currentTheme = document.body.getAttribute('data-theme');
    if(currentTheme === 'light') {
        document.body.removeAttribute('data-theme');
        themeToggle.innerHTML = '<i class="fas fa-moon"></i>';
    } else {
        document.body.setAttribute('data-theme', 'light');
        themeToggle.innerHTML = '<i class="fas fa-sun"></i>';
    }
});
const menuIcon = document.getElementById('menu-icon');
const navbar = document.querySelector('.navbar');

menuIcon.addEventListener('click', () => {
    menuIcon.classList.toggle('fa-times');
    navbar.classList.toggle('active');
});
document.querySelectorAll('.navbar a').forEach(link => {
    link.addEventListener('click', () => {
        menuIcon.classList.remove('fa-times');
        navbar.classList.remove('active');
    });
});
function initTypingEffect() {
    const words = ["Frontend Developer", "Problem Solver", "Software Engineer"];
    let wordIdx = 0, charIdx = 0, isDeleting = false;
    const target = document.querySelector('.typing-text');

    function type() {
        const currentWord = words[wordIdx];
        if (isDeleting) {
            target.textContent = currentWord.substring(0, charIdx - 1);
            charIdx--;
        } else {
            target.textContent = currentWord.substring(0, charIdx + 1);
            charIdx++;
        }

        let typeSpeed = isDeleting ? 50 : 150;

        if (!isDeleting && charIdx === currentWord.length) {
            typeSpeed = 1500; 
            isDeleting = true;
        } else if (isDeleting && charIdx === 0) {
            isDeleting = false;
            wordIdx = (wordIdx + 1) % words.length;
            typeSpeed = 500;
        }
        setTimeout(type, typeSpeed);
    }
    type();
}
const observerOptions = { threshold: 0.15, rootMargin: "0px" };
const revealObserver = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if(entry.isIntersecting) {
            entry.target.classList.add('active-reveal');
        }
    });
}, observerOptions);

document.querySelectorAll('.reveal-up, .reveal-fade, .reveal-zoom').forEach(el => revealObserver.observe(el));
function validateForm(event) {
    event.preventDefault();
    let isValid = true;

    const name = document.getElementById('name');
    const email = document.getElementById('email');
    const message = document.getElementById('message');
    if(name.value.trim() === "") {
        document.getElementById('name-error').style.display = 'block';
        isValid = false;
    } else { document.getElementById('name-error').style.display = 'none'; }
   const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if(!emailRegex.test(email.value.trim()))  {
        document.getElementById('email-error').style.display = 'block';
        isValid = false;
    } 
    else
         {
             document.getElementById('email-error').style.display = 'none';
         }
    if(message.value.trim() === "") {
        document.getElementById('message-error').style.display = 'block';
        isValid = false;
    } 
    else {
         document.getElementById('message-error').style.display = 'none';
         }

    if(isValid) {
        alert("Success! Your message was submitted structural validation successfully.");
        document.getElementById('contact-form').reset();
    }
    return isValid;
}
function downloadCertificate(file) {
    const link = document.createElement("a");
    link.href = file;
    link.download = "Programming-in-Java-NPTEL.jpg";
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
}
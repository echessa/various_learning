/*
This file contains code that populates the resume page with data
*/

var bio = {
    "name": "Joyce Echessa",
    "role": "Full Stack Web Developer",
    "welcomeMessage": "Hi. My name is Joyce. I am a Full Stack Web Developer with 5 years of experience.",
    "biopic": "images/joyce.jpg",
    "contacts": {
        "mobile": "123-456-7890",
        "email": "joyce@example.com",
        "github": "echessa",
        "twitter": "joyceechessa",
        "location": "Nairobi, Kenya"
    },
    "skills": ["Python", "React.js", "Angular.js", "Node.js"],
    display: function() {
        var formattedName = HTMLheaderName.replace("%data%", bio.name);
        var formattedRole = HTMLheaderRole.replace("%data%", bio.role);
        var formattedMobileContact = HTMLmobile.replace("%data%", bio.contacts.mobile);
        var formattedEmailContact = HTMLemail.replace("%data%", bio.contacts.email);
        var formattedGithubContact = HTMLgithub.replace("%data%", bio.contacts.github);
        var formattedTwitterContact = HTMLtwitter.replace("%data%", bio.contacts.twitter);
        var formattedLocationContact = HTMLlocation.replace("%data%", bio.contacts.location);
        var formattedBioPic = HTMLbioPic.replace("%data%", bio.biopic);
        var formattedWelcomeMessage = HTMLwelcomeMsg.replace("%data%", bio.welcomeMessage);

        $("#header").prepend(formattedRole);
        $("#header").prepend(formattedName);

        $("#topContacts").append(formattedMobileContact);
        $("#topContacts").append(formattedEmailContact);
        $("#topContacts").append(formattedGithubContact);
        $("#topContacts").append(formattedTwitterContact);
        $("#topContacts").append(formattedLocationContact);

        $("#footerContacts").append(formattedMobileContact);
        $("#footerContacts").append(formattedEmailContact);
        $("#footerContacts").append(formattedGithubContact);
        $("#footerContacts").append(formattedTwitterContact);
        $("#footerContacts").append(formattedLocationContact);

        $("#header").append(formattedBioPic);
        $("#header").append(formattedWelcomeMessage);

        if (bio.skills.length > 0) {
            $("#header").append(HTMLskillsStart);

            var formattedSkill;

            bio.skills.forEach(function(skill) {
                formattedSkill = HTMLskills.replace("%data%", skill);
                $("#skills").append(formattedSkill);
            });
        }
    }
};

var education = {
    "schools": [
        {
            "name": "Jomo Kenyatta University of Agriculture and Technology",
            "location": "Juja, Kenya",
            "degree": "BS",
            "majors": ["Math", "CS"],
            "dates": "2007-2011",
            "url": "http://www.jkuat.ac.ke/"
        }
    ],
    "onlineCourses": [
        {
            "title": "Frontend Nanodegree",
            "school": "Udacity",
            "dates": "2016-2016",
            "url": "https://www.udacity.com/course/front-end-web-developer-nanodegree--nd001"
        },
        {
            "title": "Fullstack Nanodegree",
            "school": "Udacity",
            "dates": "2016-2016",
            "url": "https://www.udacity.com/course/full-stack-web-developer-nanodegree--nd004"
        },
        {
            "title": "Senior Web Developer Nanodegree",
            "school": "Udacity",
            "dates": "2016-2016",
            "url": "https://www.udacity.com/course/senior-web-developer-nanodegree-by-google--nd802"
        }
    ],
    display: function() {
        education.schools.forEach(function(school) {
            var formattedSchoolName = HTMLschoolName.replace("%data%", school.name);
            var formattedSchoolDegree = HTMLschoolDegree.replace("%data%", school.degree);
            var formattedSchoolTitle = formattedSchoolName + formattedSchoolDegree;
            var formattedSchoolDates = HTMLschoolDates.replace("%data%", school.dates);
            var formattedSchoolLocation = HTMLschoolLocation.replace("%data%", school.location);
            var formattedSchoolMajors = HTMLschoolMajor.replace("%data%", school.majors.join(', '));

            $("#education").append(HTMLschoolStart);
            $(".education-entry:last").append(formattedSchoolTitle);
            $(".education-entry:last").append(formattedSchoolDates);
            $(".education-entry:last").append(formattedSchoolLocation);
            $(".education-entry:last").append(formattedSchoolMajors);
        });

        if (education.onlineCourses.length > 0) {
            $("#education").append(HTMLonlineClasses);

            education.onlineCourses.forEach(function(course) {
                var formattedCourseName = HTMLonlineTitle.replace("%data%", course.title);
                var formattedCourseSchool = HTMLonlineSchool.replace("%data%", course.school);
                var formattedCourseTitle = formattedCourseName + formattedCourseSchool;
                var formattedCourseDates = HTMLonlineDates.replace("%data%", course.dates);
                var formattedCourseURL = HTMLonlineURL.replace("%data%", course.url);

                $("#education").append(HTMLschoolStart);
                $(".education-entry:last").append(formattedCourseTitle);
                $(".education-entry:last").append(formattedCourseDates);
                $(".education-entry:last").append(formattedCourseURL);
            });
        }
    }
};

var work = {
    "jobs": [
        {
            "employer": "Self Employed",
            "title": "Full Stack Python Developer",
            "location": "Nairobi",
            "dates": "2013-2016",
            "description": "Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat."
        },
        {
            "employer": "Sprout Consulting",
            "title": "Ruby on Rails Backend Developer",
            "location": "Nairobi",
            "dates": "2012-2013",
            "description": "Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem."
        },
        {
            "employer": "JJ People Kenya Limited",
            "title": "Java Backend Developer",
            "location": "Nairobi",
            "dates": "2011-2012",
            "description": "Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur."
        }
    ],
    display: function() {
        work.jobs.forEach(function(job) {
            var formattedEmployer = HTMLworkEmployer.replace("%data%", job.employer);
            var formattedTitle = HTMLworkTitle.replace("%data%", job.title);
            var formattedEmployerTitle = formattedEmployer + formattedTitle;
            var formattedDates = HTMLworkDates.replace("%data%", job.dates);
            var formattedDescription = HTMLworkDescription.replace("%data%", job.description);
            var formattedLocation = HTMLworkLocation.replace("%data%", job.location);

            $("#workExperience").append(HTMLworkStart);
            $(".work-entry:last").append(formattedEmployerTitle);
            $(".work-entry:last").append(formattedDates);
            $(".work-entry:last").append(formattedLocation);
            $(".work-entry:last").append(formattedDescription);
        });
    }
};

var projects = {
    "projects": [
        {
            "title": "Online Markdown Editor",
            "dates": "2015-2016",
            "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            "images": ["https://placehold.it/350x200", "https://placehold.it/350x200", "https://placehold.it/350x200"]
        },
        {
            "title": "Content Management System",
            "dates": "2014-2015",
            "description": "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.",
            "images": ["https://placehold.it/350x200", "https://placehold.it/350x200", "https://placehold.it/350x200"]
        },
        {
            "title": "E-store Management Software",
            "dates": "2013-2013",
            "description": "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio.",
            "images": ["https://placehold.it/350x200", "https://placehold.it/350x200", "https://placehold.it/350x200"]
        }
    ],
    display: function() {
        projects.projects.forEach(function(project) {
            var formattedTitle = HTMLprojectTitle.replace("%data%", project.title);
            var formattedDates = HTMLprojectDates.replace("%data%", project.dates);
            var formattedDescription = HTMLprojectDescription.replace("%data%", project.description);
            
            $("#projects").append(HTMLprojectStart);
            $(".project-entry:last").append(formattedTitle);
            $(".project-entry:last").append(formattedDates);
            $(".project-entry:last").append(formattedDescription);

            if (project.images.length > 0) {
                project.images.forEach(function(image) {
                    var formattedImage = HTMLprojectImage.replace("%data%", image);
                    $(".project-entry:last").append(formattedImage);
                });
            }
        });
    }
};

bio.display();
work.display();
projects.display();
education.display();

$("#mapDiv").append(googleMap);

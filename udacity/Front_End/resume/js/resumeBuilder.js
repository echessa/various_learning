/*
This is empty on purpose! Your code to build the resume will go here.
 */
 var name = "Joyce Echessa";
 var role = "Full Stack JavaScript Developer";
 var formattedName = HTMLheaderName.replace("%data%", name);
 var formattedRole = HTMLheaderRole.replace("%data%", role);
 $("#header").prepend(formattedRole);
 $("#header").prepend(formattedName);

 var bio = {
   "name": name,
   "role": role,
   "contact info": {
     "mobile": "123",
     "email": "jo@jo.com",
     "location": "Diagon Alley"
   },
   "picture URL": "",
   "welcome message": "yo",
   "skills": []
 }

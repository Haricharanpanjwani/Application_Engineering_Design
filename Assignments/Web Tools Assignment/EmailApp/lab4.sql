use WebTools;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: newton.neu.edu    Database: usersdb
-- ------------------------------------------------------
-- Server version	5.6.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE contacts (
  contactID int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  userName varchar(6) NOT NULL DEFAULT '',
  contactName varchar(6) NOT NULL DEFAULT '',
  comments text NOT NULL,
  dateAdded varchar(13) NOT NULL DEFAULT '',
  PRIMARY KEY (contactID)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts`
--

LOCK TABLES contacts WRITE;
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO contacts VALUES (0000000005,'marry','yusuf','seems like a nice guy','Sat Dec 06 19:44:27 EST 2003');
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE countries (
  countryName varchar(33) NOT NULL DEFAULT '',
  PRIMARY KEY (countryName)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO countries VALUES ('Afghanistan'),('Albania'),('Algeria'),('Andorra'),('Angola'),('Anguilla'),('Antarctica'),('Antigua & Barbuda'),('Argentina'),('Armenia'),('Aruba'),('Australia'),('Austria'),('Azerbaijan'),('Bahamas'),('Bahrain'),('Bangladesh'),('Barbados'),('Belarus'),('Belgium'),('Belize'),('Benin'),('Bermuda'),('Bhutan'),('Bolivia'),('Bosnia-Herzogna'),('Botswana'),('Brazil'),('Brunei'),('Bulgaria'),('Burkina Faso'),('Burundi'),('Cambodia'),('Cameroon'),('Canada'),('Cape Verde'),('Cayman Islands'),('Central African Rep.'),('Chad'),('Chile'),('China'),('Christmas Island'),('Cocos (Keeling) Is.'),('Colombia'),('Comoros'),('Congo'),('Congo (Zaire)'),('Costa Rica'),('Cote D\'Ivoire'),('Croatia (Hrvatska)'),('Cyprus'),('Czech Rep.'),('Denmark'),('Djibouti'),('Dominica'),('Dominican Rep.'),('East Timor'),('Ecuador'),('Egypt'),('El Salvador'),('Equatorial Guinea'),('Eritrea'),('Estonia'),('Ethiopia'),('Falkland Is.'),('Faroe Islands'),('Fiji Islands'),('Finland'),('France'),('French Guiana'),('French Polynesia'),('French So. Terr.'),('Gabon'),('Gambia'),('Georgia'),('Germany'),('Ghana'),('Gibraltar'),('Greece'),('Greenland'),('Grenada'),('Guadeloupe'),('Guam'),('Guatemala'),('Guinea'),('Guinea-Bissau'),('Guyana'),('Haiti'),('Honduras'),('Hong Kong (China)'),('Hungary'),('Iceland'),('India'),('Indonesia'),('Ireland'),('Israel'),('Italy'),('Jamaica'),('Japan'),('Jordan'),('Kazakhstan'),('Kenya'),('Kiribati'),('Korea, South'),('Kuwait'),('Kyrgyzstan'),('Laos'),('Latvia'),('Lebanon'),('Lesotho'),('Liechtenstein'),('Lithuania'),('Luxembourg'),('Macau (China)'),('Macedonia'),('Madagascar'),('Malawi'),('Malaysia'),('Maldives'),('Mali'),('Malta'),('Martinique'),('Mauritania'),('Mauritius'),('Mayotte'),('Mexico'),('Moldova'),('Monaco'),('Mongolia'),('Montserrat'),('Morocco'),('Mozambique'),('Myanmar'),('Namibia'),('Nauru'),('Nepal'),('Netherlands'),('Netherlands Ant.'),('New Caledonia'),('New Zealand'),('Nicaragua'),('Niger'),('Nigeria'),('Niue'),('No. Mariana Is.'),('Norfolk Island'),('Norway'),('Oman'),('Pakistan'),('Palau'),('Panama'),('Papua new Guinea'),('Paraguay'),('Peru'),('Philippines'),('Pitcairn Is.'),('Poland'),('Portugal'),('Puerto Rico'),('Qatar'),('Reunion'),('Romania'),('Russia'),('Rwanda'),('Saint Helena'),('Saint Kitts & Nevis'),('Saint Lucia'),('Samoa'),('San Marino'),('Sandwich Islands'),('Sao Tome & Prin.'),('Saudi Arabia'),('Senegal'),('Seychelles'),('Sierra Leone'),('Singapore'),('Slovakia'),('Slovenia'),('Solomon Islands'),('Somalia'),('South Africa'),('Spain'),('Sri Lanka'),('St. Pierre & Miq\'n'),('St. Vincent & Gred\'s.'),('Sudan'),('Suriname'),('Svalbard & J. May\'n'),('Swaziland'),('Sweden'),('Switzerland'),('Syria'),('Taiwan'),('Tajikistan'),('Tanzania'),('Thailand'),('The Vatican'),('Togo'),('Tokelau'),('Tonga'),('Trinidad & Tobago'),('Tunisia'),('Turkey'),('Turkmenistan'),('Turks & Caicos Is.'),('Tuvalu'),('UAE'),('Uganda'),('Ukraine'),('United Kingdom'),('Uruguay'),('USA'),('Uzbekistan'),('Vanuatu'),('Venezuela'),('Vietnam'),('Virgin Islands (UK)'),('Virgin Islands (USA)'),('Wallis & Futuna Is.'),('Western Sahara'),('Yemen'),('Yugoslavia'),('Zambia'),('Zimbabwe');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE messages (
  messageID int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  userName varchar(6) NOT NULL DEFAULT '',
  fromUser varchar(6) NOT NULL DEFAULT '',
  message text NOT NULL,
  messageDate varchar(13) NOT NULL DEFAULT '',
  PRIMARY KEY (messageID)
) ENGINE=MyISAM AUTO_INCREMENT=553941545 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO messages VALUES (0000000037,'pam','toni','hi there, tony','12/3/2003'),(0000000038,'marry','joe','hi from joe','12/7/2003'),(0000000039,'marry','toni','this is tony','12/5/2003'),(0000000036,'pam','mickey','hi from mickey','12/5/2003'),(0000000035,'pam','joe','this is joe','12/7/2003'),(0000000034,'pam','jack','this is jack','12/7/2003'),(0000000002,'jenny','ankit','Hi',''),(0000000028,'jenny','mickey','message from mickey','12/6/2003'),(0000006917,'jenny','mickey','test',''),(0000002493,'jenny','mickey','take',''),(0000005246,'jenny','mickey','jgjgj',''),(0000004559,'jenny','ankit','mvv',''),(0000004404,'jenny','joe','dsa',''),(0000000001,'jenny','null','qhqhqhq',''),(0000000027,'jenny','joe','message from joe','12/3/2003'),(0000001992,'jenny','ankit','hi',''),(0553941544,'jenny','null','saggg',''),(0000000040,'marry','jack','from jack','12/6/2003'),(0000000041,'marry','mickey','this is mickey','12/5/2003'),(0000000042,'marry','yusuf','hi from yusuf','12/6/2003'),(0000000044,'jack','jenny','hi from jenny','12/5/2003'),(0000000045,'jack','pam','hi from pam','12/6/2003'),(0000000054,'toni','marry','hello from marry','12/6/2003'),(0000000046,'joe','pam','from pam','12/7/2003'),(0000000047,'joe','jenny','from jenny','12/6/2003'),(0000000048,'joe','marry','from marry','12/5/2003'),(0000000049,'mickey','jenny','hi this is jenny','12/7/2003'),(0000000050,'mickey','marry','hello, this is marry','12/5/2003'),(0000000051,'mickey','pam','hi mickey, this is pam','12/6/2003'),(0000000052,'toni','pam','hi from pam','12/4/2003'),(0000000053,'toni','jenny','hi from jenny','12/5/2003'),(0000000055,'jack','marry','hello, this is marry','12/5/2003'),(0000004460,'jenny','mickey','hi',''),(0000009287,'jenny','mickey','yo',''),(0000009531,'jenny','ankit','hello',''),(0000001934,'jenny','mickey','hihihih',''),(0000003016,'mickey','jenny','from kumaran',''),(0000001866,'jenny','mickey','hi from webtool lab',''),(0000000407,'jenny','mickey','took',''),(0000006983,'jenny','mickey','yo',''),(0000008890,'jenny','mickey','hello',''),(0000002945,'jenny','mickey','test',''),(0000007018,'mickey','jenny','hey yo wassup',''),(0000004275,'jenny','mickey','ssupp',''),(0000006082,'mickey','jenny','2134',''),(0000002486,'mickey','marry','helloz',''),(0000005924,'mickey','jenny','this is mickey',''),(0000000207,'mickey','jenny','hey jenny kumaran',''),(0000005345,'mickey','jenny','hey kumaran here',''),(0000006735,'jenny','mickey','LAB 4 TEST',''),(0000004029,'jenny','mickey','sup yoooo',''),(0000002272,'jenny','mickey','message testing',''),(0000008662,'mickey','jenny','test58676',''),(0000002145,'mickey','marry','Hey this is mickey here',''),(0000009209,'mickey','jenny','new reply',''),(0000007615,'jenny','ankit','welcome to web tools',''),(0000003744,'jenny','mickey','Test159',''),(0000005546,'jenny','mickey','hghgkhh',''),(0000004346,'jenny','ankit','hello',''),(0000006462,'jenny','ankit','Hi ankit',''),(0000005672,'mickey','mickey','blahhh',''),(0000001528,'jenny','jenny','hi from mickey',''),(0000002629,'jenny','jenny','khihk',''),(0000004855,'mickey','mickey','latest test1',''),(0000000185,'jenny','mickey','yo jenny please work',''),(0000007563,'mickey','jenny','hello mickey. Lab 159',''),(0000003752,'mickey','mickey','hughjh',''),(0000001413,'jenny','joe','hi joe, how are you??',''),(0000006726,'mickey','jenny','hi mickey ssupp',''),(0000003451,'jenny','ankit','ahah',''),(0000002603,'mickey','jenny','Hi mickey.....',''),(0000008489,'','null','null',''),(0000002544,'jenny','mickey','vwr',''),(0000001592,'mickey','jenny','cekj',''),(0000003159,'','null','null',''),(0000009885,'jenny','mickey','dev',''),(0000000118,'','jenny','wdadws',''),(0000002818,'','null','null',''),(0000005430,'jenny','jenny','hgffghd',''),(0000006422,'','null','null',''),(0000006134,'','null','null',''),(0000006898,'jenny','mickey','i luvvv you',''),(0000002564,'mickey','jenny','i love you too',''),(0000001271,'jenny','ankit','ahahah',''),(0000009441,'jenny','ankit','Hi Ankit',''),(0000004453,'mickey','jenny','hi thus is lab 4.',''),(0000002561,'joe','jenny','hi joe ',''),(0000008370,'marry','mickey','jkhjkhk','');
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userstable`
--

DROP TABLE IF EXISTS `userstable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE userstable (
  UserID int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  UserName varchar(16) NOT NULL DEFAULT '',
  UserPassword varchar(16) NOT NULL DEFAULT '',
  DOBmonth int(11) unsigned NOT NULL DEFAULT '0',
  DOBday int(11) unsigned NOT NULL DEFAULT '0',
  DOByear int(11) unsigned NOT NULL DEFAULT '0',
  age int(11) unsigned NOT NULL DEFAULT '0',
  lastLoginDate varchar(36) NOT NULL DEFAULT '',
  Email varchar(34) NOT NULL DEFAULT '',
  Gender varchar(6) NOT NULL DEFAULT '',
  SeekingGender varchar(6) NOT NULL DEFAULT '',
  Country varchar(17) NOT NULL DEFAULT '',
  State varchar(17) NOT NULL DEFAULT '',
  City varchar(17) NOT NULL DEFAULT '',
  PostalCode varchar(10) NOT NULL DEFAULT '',
  AboutMe1 text NOT NULL,
  FileLocation varchar(34) NOT NULL DEFAULT '',
  Height int(11) unsigned NOT NULL DEFAULT '0',
  Weight int(11) unsigned NOT NULL DEFAULT '0',
  StudiesEmphasis varchar(85) NOT NULL DEFAULT '',
  RelocateFlag varchar(16) NOT NULL DEFAULT '',
  Headline text NOT NULL,
  Occupation varchar(85) NOT NULL DEFAULT '',
  OccupationDescription varchar(85) NOT NULL DEFAULT '',
  GrewUpIn varchar(34) NOT NULL DEFAULT '',
  ZodiacSign varchar(20) NOT NULL DEFAULT '',
  Languages varchar(85) NOT NULL DEFAULT '',
  RelationshipType varchar(85) NOT NULL DEFAULT '',
  MaritalStatus varchar(34) NOT NULL DEFAULT '',
  HairColor varchar(14) NOT NULL DEFAULT '',
  IncomeLevel varchar(34) NOT NULL DEFAULT '',
  EducationLevel varchar(67) NOT NULL DEFAULT '',
  BodyType varchar(67) NOT NULL DEFAULT '',
  AppearanceImportance varchar(34) NOT NULL DEFAULT '',
  Religion varchar(34) NOT NULL DEFAULT '',
  EyeColor varchar(17) NOT NULL DEFAULT '',
  Ethnicity varchar(34) NOT NULL DEFAULT '',
  PoliticalOrientation varchar(34) NOT NULL DEFAULT '',
  IntelligenceImportance varchar(17) NOT NULL DEFAULT '',
  SmokingHabits varchar(17) NOT NULL DEFAULT '',
  ActivityLevel varchar(34) NOT NULL DEFAULT '',
  Custody varchar(34) NOT NULL DEFAULT '',
  DrinkingHabits varchar(17) NOT NULL DEFAULT '',
  MoreChildrenFlag varchar(17) NOT NULL DEFAULT '',
  AboutMe2 text NOT NULL,
  PersonalityTrait varchar(85) NOT NULL DEFAULT '',
  LeisureActivity varchar(85) NOT NULL DEFAULT '',
  PerfectMatchEssay text NOT NULL,
  Cuisine varchar(85) NOT NULL DEFAULT '',
  Music varchar(85) NOT NULL DEFAULT '',
  Reading varchar(85) NOT NULL DEFAULT '',
  PerfectFirstDateEssay text NOT NULL,
  EntertainmentLocation varchar(85) NOT NULL DEFAULT '',
  PhysicalActivity varchar(85) NOT NULL DEFAULT '',
  IdealRelationshipEssay text NOT NULL,
  LearnFromThePastEssay text NOT NULL,
  PRIMARY KEY (UserID)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userstable`
--

LOCK TABLES `userstable` WRITE;
/*!40000 ALTER TABLE `userstable` DISABLE KEYS */;
INSERT INTO userstable VALUES (0000000007,'jenny','password',1,1,1970,33,'Tue Dec 09 14:17:56 EST 2003','jenny@hotmail.com','Female','Male','USA','NH','Manchester','02220','I look great','images/lady2.jpg',170,59,'Software','0','Call me','Student','Description','Boston','Gemini','Urdu Vietnamese Yiddish','A Date,','Single','Blonde','Will tell you later','Doctorate','Zaftig','Not important','Unaffiliated','Hazel','South Asian/East Indian','Extreme Liberal','Most Important','Non-Smoker','Active','I have no kids','Never','1','This is me, I will tell you later','Adventurous/Wild/Spontaneous, Argumentative,','Antiquing, Board Games/Backgammon/Chess,','I am looking for an honest person','American, Barbecue,','Alternative, Big Band/Swing,','Fiction,','It should be at a romantic restaurant','Amusement Parks,','Aerobics,','My perception of an ideal relationship','What Ive learned from my past relationships...'),(0000000006,'yusuf','password',1,1,1986,30,'Dec 12','email','Male','Female','usa','ma','city','02115','aboutme','images/nopicture.jpg',175,100,'studies','relocate','headline','Occupation','Occupation Description','Grew up in','Zodiac Sign','Languages I speak','Type of RelationshipType seeking','I','Hair Color','Income Level','Education Level:','Body Type','Rate appearance:','Religion','Eye Color','Ethnicity','Ethnicity','Rate Intelligence','Smoking Habits','Activity Level','Custody','Drinking Habits','Want more','About Me','My personality traits:','My favorite activities','ss','ss','ss','ss','ss','ss','ss','ss','great'),(0000000012,'pam','password',5,10,1975,28,'','ccc','Female','Male','USA','new york','Boston','02226','I am considered the class clown type. I need someone who can take my sharp tongue and verbal wit!:) Im 1/2 Thai and 1/2 White. But no one can ever figure this out and I have had many people start talking in Spanish to me.','images/lady1.jpg',165,50,'java','no','Single Female seeking Male','Programmer','Grewat Java Programmer','Newyork','Gemini','English','Friendship','single','black','50000','Masters','Slim','No','Jewish','blue','Hispanic','Democrat','yes','no','Active','1 kid','Never','no','Taking road trips to new places. Spending time with friends and family are important. I am pretty easy to get along with as long as you can conversate with me ','Adventurous','Board Games','My new essay is being approved by Customer Care. Check back soon to find out more about me','French','Techno','Fiction','Well that would depend on how adventurous and sponteineous \r\n ','Mo','Ba','You actually have to like the person you are with and consider them a friend aside from the love part. Trust, ','You actually have to like the person you are with and consider them a friend aside from the love part. Trust, communication, '),(0000000013,'jack','1234',1,1,1970,33,'Thu Dec 11 12:31:12 EST 2003','jack@hotmail.com','Male','Female','USA','MA','Boston','02134','','images/nopicture.jpg',195,59,'wwwwwwwwwwwwwwwww','0','wwww','Technical/Science/Engineering','wwwwwwwwwwwwww','wwwww','Cancer','Arabic English','A Date,','Single','Other','Under $15,000','High School','Muscular','Low Importance','Unaffiliated','Blue','African Descent/Black','Extreme Liberal','Not important','Occasional Smoker','Rarely Active','Sometimes','On occasion','0','wwwwwwwwwwwwwwwwwwwwwww','Adventurous/Wild/Spontaneous,','Antiquing,','kkkkkkkkkkkkkkkkkkkk','Deli,','Alternative,','Newspapers,','lllllllllllllllllllll','Amusement Parks,','Golf,','hhhhhhhhhhhhhhhhhhhhhh','jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj'),(0000000016,'joe','1234',10,10,1972,31,'','joe@hotmail.com','Male','Female','USA','MA','Boston','02114','','images/joe.jpg',150,85,'','','','Consultant','','New Hamphire','','German','Friend','Single','Blonde','Later','Bachelors','Slim','No','Christian','','White','Republican','No','No','Active','2 kids','never','1','I am Not a subscriber, Please IM or via dzablat at the opposite of cold and well you know the rest!; I am person who is very active athletically and socially!! I enjoy playing most sports as well inging, acting, dancing, playing the trumpet, going to the theatre, musuems, the beach and basically enjoying life to the fullest!! I am enjoy eating at all types of restaurants and being their for my friends and family!!','Adventurous/Wild/Spontaneous, Artistic, Compulsive, Conservative/Clean','','','','','','','','','',''),(0000000015,'mickey','mouse',1,1,1970,33,'Sat Dec 06 19:06:10 EST 2003','mickey@coe.neu.edu','Male','Female','USA','MA','Boston','02115','','images/mickey.jpg',190,89,'Engineering Software Design','1','Just a regular guy','Technical/Science/Engineering','Java servlet/jsp programmer','Boston','Aquarius','English French German','A Date, Friend,','Single','Black','$50,000 - $100,000','Ph.D./Postdoctoral','Muscular','Not important','Jewish','Blue','Native American','Liberal','Most Important','Non-Smoker','Very Active','I have no kids','Never','0','Hi im a very down to earth person, not into the whole bar scene. I thought I would give this a chance Im very funny, love to laugh and have a good time. I never have a dull moment and I always know what to say lol I have 2 kids my daughter lives with me and my son lives with his mom and they are the most important thing in my life . but one thing is missing and that could be you hope to hear from u wayne aug 34 aonline','Outgoing, Practical, Procrastinator,','Cooking/Barbecuing, Dining Out, Entertaining,','Im looking for sombody that wants to be my best friend. She has to be someone I can look into her eyes and just know that we will always be together forever','Italian, Korean, Mediterranean, Mexican,','Dance/Electronica, Disco,','Fiction, Newspapers, Poetry,','I will just be able to feel it know matter what we do but I would just like to go somewhere quiet and just talk and get to know each other ','Beach, Bookstores,','Basketball, Bowling,','Trust thats the one thing that is most important to me . we must be best friends and be able to tell each other everything good or bad .','just be yourself . you cant change someone no matter how bad you want to everyone has thier own mind just let them make up thier own'),(0000000017,'toni','pass',2,3,1965,38,'','','Male','Female','USA','NY','Newyork City','11111','','images/toni.jpg',180,90,'','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','',''),(0000000018,'marry','246',10,25,1975,28,'','','Female','Male','USA','MA','','','','images/marry.jpg',165,50,'','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','',''),(0000000019,'ldy','ldyldy',1,1,1980,23,'Tue Dec 01 16:09:36 EST 2015','123@123.com','Female','Female','USA','MA','Boston','02222','hello hello','images/nopicture.jpg',137,38,'aa','0','headline','Advertising/Marketing/PR','aa','abcd','Aquarius','English Polish ','A Date, ','Single','Bald/Shaved','$15,000 - $25,000','High School','Athletic/Fit','Medium Importance','Anglican','Blue Green','Asian','Left Wing','Medium Importance','Trying to quit','Never Active','Sometimes','Socially','0','about me about me','Argumentative, Intellectual, ','Gambling, Motorcycling, ','i m looking for abc abc abc','Greek, Jewish/Kosher, ','Latin<, New Age, ','Magazines, ','data date date','Beach, Dances - Line, Ballroom, Tango, ','Bowling, Jet/Water Skiing, Swimming/Diving/Water Polo, ','relation ship ','relation ship'),(0000000020,'ajinkya','admin',1,1,1982,21,'Wed Dec 02 16:56:32 EST 2015','peshave.aj@husky.neu.edu','Male','Female','USA','','','02134','','images/nopicture.jpg',185,90,'Masters','1','sssssdsd','Administrative/Human Resources','sss','sdssss','Aquarius','English ','A Date, ','Single','Auburn','Will tell you later','High School','Athletic/Fit','Medium Importance','Hindu','Blue','Asian','Moderate','Medium Importance','Non-Smoker','Selected activities','I have no kids','On occasion','0','hahaahhahahhah','Argumentative, Outgoing, Simple, ','Hanging Out with Friends, Motorcycling, Traveling/Weekend Trips/Adventure Travel, ','jkbkjhkjlknlhlh lknlkl','Caribbean/Cuban, Middle Eastern, Spanish, ','Jazz, New Age, Soul/R&B, Punk, ','Poetry, ','ddd d gfd f s ds d s  fg d g','Concerts, Live Theater, Shopping Malls, ','Working Out/Weightlifting, Dancing, Snorkeling/Scuba Diving, ','dfddfdfd sdfsdfsd fsdfsdf','dfsdfsd  sdf s  dfs df sdf  sdf sd f sdf sdf sdf sdf s df sd');
/*!40000 ALTER TABLE `userstable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-06 14:17:08

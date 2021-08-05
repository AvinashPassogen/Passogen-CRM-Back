CREATE TABLE IF NOT EXISTS `countries` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `sortname` varchar(3) NOT NULL,
  `name` varchar(150) NOT NULL,
  `phonecode` bigint(11) NOT NULL,
  is_active bit(1) DEFAULT b'1',
    created_by varchar(255) DEFAULT NULL,
    creation_date timestamp NULL DEFAULT NULL,
    last_modified_by varchar(255) DEFAULT NULL,
    last_modified_date timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `states` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `country_id` bigint(11) NOT NULL DEFAULT '1',
  is_active bit(1) DEFAULT b'1',
  created_by varchar(255) DEFAULT NULL,
    creation_date timestamp NULL DEFAULT NULL,
    last_modified_by varchar(255) DEFAULT NULL,
    last_modified_date timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  constraint fk_states_country foreign key (country_id) references countries(id)
);

CREATE TABLE IF NOT EXISTS `cities` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `state_id` bigint(11) NULL,
  is_active bit(1) DEFAULT b'1',
  created_by varchar(255) DEFAULT NULL,
    creation_date timestamp NULL DEFAULT NULL,
    last_modified_by varchar(255) DEFAULT NULL,
    last_modified_date timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `lead_management` (
  `plid` int(11) NOT NULL,
  `salutation` varchar(20) NOT NULL,
  `First_Name` varchar(255) DEFAULT NULL,
  `Middle_Name` varchar(255) NOT NULL,
  `Last_Name` varchar(255) NOT NULL,
  `Title` varchar(255) NOT NULL,
  `Company_Name` varchar(255) NOT NULL,
  `Industry` varchar(255) NOT NULL,
  `Phone_Number` varchar(20) NOT NULL,
  `Mobile_Number` varchar(20) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Lead_Status` varchar(255) NOT NULL,
  `Owner` varchar(255) NOT NULL,
  `No_Of_Employees` varchar(255) NOT NULL,
  `Lead_Source` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Pincode` varchar(20) NOT NULL,
  `Country` varchar(50) NOT NULL,
  `State` varchar(255) NOT NULL,
  `City` varchar(50) NOT NULL,
  `Rating` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `contacts` (
  `id` int(255) NOT NULL,
  `salutation` varchar(255) NOT NULL,
  `first_Name` varchar(255) NOT NULL,
  `middle_Name` varchar(255) NOT NULL,
  `last_Name` varchar(255) NOT NULL,
  `contacts_owner` varchar(255) DEFAULT NULL,
  `account_Name` varchar(255) NOT NULL,
  `reports_To` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `department` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `fax` varchar(255) NOT NULL,
  `phone_Number` varchar(255) NOT NULL,
  `mobile_Number` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `pincode` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `contacts`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contacts`
--
ALTER TABLE `contacts`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;
COMMIT;
<?php

$db_hostname = "localhost";
$db_username = "sandra";
$db_password = "123456789";
$db_database = "AttendanceDB";

$connection = new mysqli($db_hostname, $db_username, $db_password, $db_database);

if ($connection->connect_error){

	die ($connection->connect_error);
} 
else{
	//echo "Connection Successful";
}

?>

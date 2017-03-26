<?php

//establishing connection to the database
require "init.php";


$name=$_POST["name"]
$email=$_POST["email"]
$course=$_POST["course_name"]
$password=$_POST["password"];

//Insert info into the database

$sql_query= "INSERT INTO teacher(`name` , `email` ,`course_name`, `password`) values('$name', '$email', '$course_name', '$password');";


if (mysqli_query($connection, $sql_query))
{
	//echo "data insertion success";
}

else
{
	//echo " data insertion error..";
	//print_r($connection->error);
}


?>
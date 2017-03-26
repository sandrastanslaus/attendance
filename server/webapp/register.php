<?php

//establishing connection to the database
require "init.php";


$user=$_POST["name"]
$username=$_POST["username"]
$password=$_POST["password"];

//Insert info into the database

$sql_query= "INSERT INTO students(`username`, `name` , `password`) values('$username' ,'$name','$password');";


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
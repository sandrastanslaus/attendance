<?php
require "init.php";

//retrieve information from the table

$email= $_POST ["email"];
$password=$_POST["password"];

$sql_query= "SELECT * FROM teacher WHERE email='$email' AND password='$password' LIMIT 1;";

echo "<br>";    // this is for line break

//execute query

$result = mysqli_query($connection, $sql_query);

if(mysqli_num_rows($result)>0)
{
	$row= mysqli_fetch_assoc($result);
	$email=$row ["email"];

	echo "login Succes.... ";
}

else
{
	echo "login failed... try again";
}





?>
import React, { useEffect, useRef, useState } from "react";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const navigate = useNavigate();
  const emailRef = useRef();
  const passRef = useRef();

  useEffect(() => {
    emailRef.current.focus();
    passRef.current.focus();
  }, []);

  const checkPass = () => {
    if (
      emailRef.current.value === "admin" &&
      passRef.current.value === "admin"
    ) {
      navigate("/successLogin");
    }
  };

  return (
    <div className="">
      <label htmlFor="email">Email</label>
      <input type="text" ref={emailRef} />
      <br />
      <label htmlFor="pass">Password</label>
      <input type="text" ref={passRef} />
      <br />
      <button onClick={checkPass}>Login</button>
      <button>Cancel</button>
    </div>
  );
};

export default Login;

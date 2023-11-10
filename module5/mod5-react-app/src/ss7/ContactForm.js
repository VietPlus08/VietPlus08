import React from "react";
import { useForm } from "react-hook-form";

const ContactForm = () => {
  const {
    register,
    handleSubmit,
    reset,
    setValue,
    formState: { errors },
    watch,
    setError,
  } = useForm();

  const onSubmit = (data) => {
    console.log("vào console.log");
    console.log(data);
  };

  return (
    <div className="">
      <form onSubmit={handleSubmit(onSubmit)}>
        <label htmlFor="name">Name</label>
        <input
          type="text"
          {...register("name", {
            required: {
              value: true,
              message: "Vui lòng nhập tối thiểu 3 kí tự",
            },
            minLength: {
              value: 3,
              message: "Vui lòng nhập tối thiểu 3 kí tự",
            },
            maxLength: {
              value: 25,
              message: "Vui lòng nhập tối đa 25 kí tự",
            },
          })}
        />
        {errors.name && (
          <span className="errorText">{errors.name.message}</span>
        )}
        <br />
        <label htmlFor="email">Email</label>
        <input
          type="text"
          {...register("email", {
            required: {
              value: true,
              message: "Vui lòng nhập tối thiểu 3 kí tự",
            },
            minLength: {
              value: 3,
              message: "Vui lòng nhập tối thiểu 3 kí tự",
            },
            maxLength: {
              value: 25,
              message: "Vui lòng nhập tối đa 25 kí tự",
            },
          })}
        />
        {errors.email && (
          <span className="errorText">{errors.email.message}</span>
        )}
        <br />
        <label htmlFor="phone">Phone</label>
        <input
          type="text"
          {...register("phone", {
            maxLength: {
              value: 25,
              message: "Vui lòng nhập tối đa 25 kí tự",
            },
          })}
        />
        {errors.phone && (
          <span className="errorText">{errors.phone.message}</span>
        )}
        <br />
        <label htmlFor="message">Message</label>
        <input
          type="text"
          {...register("message", {
            maxLength: {
              value: 25,
              message: "Vui lòng nhập tối đa 25 kí tự",
            },
          })}
        />
        {errors.message && (
          <span className="errorText">{errors.message.message}</span>
        )}
        <br />
        <input type="submit"></input>
        <button>Cancel</button>
      </form>
    </div>
  );
};

export default ContactForm;

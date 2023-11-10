import React, { useState } from "react";
import { useForm } from "react-hook-form";

const Library = () => {
  const {
    register,
    handleSubmit,
    reset,
    setValue,
    formState: { errors },
    watch,
    setError,
  } = useForm();

  const [content, setContent] = useState([
    {
      title: "Book 1",
      quantity: 1,
    },
  ]);

  const [selected, setSelected] = useState({});

  const onSubmit = (data) => {
    var checkExist;
    if (content) {
      console.log("vao content");
      checkExist = content.filter((i) => i.title === data.title);
    }
    if (checkExist.length > 0) {
      console.log(checkExist);
      setContent([...content.filter((i) => i.title !== data.title), data]);
    } else {
      setContent([...content, data]);
    }
    console.log(data);
    reset();
  };

  const getInfor = (data) => {
    setValue("title", data.title);
    setValue("quantity", data.quantity);
  };

  const handleDelete = (name) => {
    console.log(name);
    setContent((prev) => prev.filter((i) => i.title != name));
  };
  return (
    <>
      <form onSubmit={handleSubmit(onSubmit)}>
        <label htmlFor="title">Tiêu đề</label>
        <input
          type="text"
          {...register("title", {
            required: {
              value: true,
              message: "Vui lòng nhập",
            },
            maxLength: {
              value: 25,
              message: "Vui lòng nhập tối đa 25 kí tự",
            },
          })}
        />
        {errors.title && (
          <span className="errorText">{errors.title.message}</span>
        )}
        <br />
        <label htmlFor="quantity">Số lượng</label>
        <input
          type="text"
          {...register("quantity", {
            required: {
              value: true,
              message: "Vui lòng nhập",
            },
            maxLength: {
              value: 25,
              message: "Vui lòng nhập tối đa 25 kí tự",
            },
          })}
        />
        {errors.quantity && (
          <span className="errorText">{errors.quantity.message}</span>
        )}
        <br />

        <input type="submit"></input>
      </form>
      <table className="table-striped table-bordered">
        <thead>
          <tr>
            <th>Title</th>
            <th>Number</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {content.length > 0 &&
            content.map((i, index) => (
              <tr key={index}>
                <td>{i.title}</td>
                <td>{i.quantity}</td>
                <td>
                  <button onClick={() => getInfor(i)}>Edit</button>
                  <button onClick={() => handleDelete(i.title)}>Delete</button>
                </td>
              </tr>
            ))}
        </tbody>
      </table>
    </>
  );
};

export default Library;

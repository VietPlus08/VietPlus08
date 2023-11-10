import React, { useState } from "react";

const Ex3 = () => {
  const [data, setData] = useState([
    {
      id: "1",
      name: "Nguyễn Văn A",
      age: "30",
      address: "Đà Nẵng",
    },
    {
      id: "2",
      name: "Nguyễn Văn A",
      age: "30",
      address: "Đà Nẵng",
    },
    {
      id: "3",
      name: "Nguyễn Văn A",
      age: "30",
      address: "Đà Nẵng",
    },
    {
      id: "4",
      name: "Nguyễn Văn A",
      age: "30",
      address: "Đà Nẵng",
    },
  ]);
  const columnName = ["Id", "Name", "Age", "Address"];

  return (
    <>
      <table className="table-striped table-bordered">
        <thead>
          <tr>
            {columnName.map((name) => (
              <th key={name}>{name}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {data.map((item) => (
            <tr key={item}>
              <td>{item.id}</td>
              <td>{item.name}</td>
              <td>{item.age}</td>
              <td>{item.address}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
};

export default Ex3;

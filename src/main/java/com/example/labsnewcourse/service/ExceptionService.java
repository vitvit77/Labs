package com.example.labsnewcourse.service;

import com.example.labsnewcourse.exceptions.MyException;
import com.example.labsnewcourse.model.Response;
import com.example.labsnewcourse.model.ResponseMessage;
import com.example.labsnewcourse.model.Type;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ExceptionService {
    /**
     *
     * @param type
     * @return
     * @throws SQLException
     */
    public Response execute(Type type) throws SQLException {
        if (Type.NullPointer.equals(type)) {
            throw new NullPointerException();
        } else if (Type.Illegal.equals(type)) {
            throw new IllegalArgumentException();
        } else if (Type.SQL.equals(type)) {
            throw new SQLException();
        }
        return new Response(Type.OK.name());
    }

    /**
     *
     * @param type
     * @return
     * @throws SQLException
     */
    public ResponseMessage executeString(Type type) throws MyException {
        if (!Type.OK.equals(type)) {
            throw new MyException("ERROR");
        }
        return new ResponseMessage("Hello");
    }
}

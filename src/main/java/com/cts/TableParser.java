package com.cts;

import com.cts.data.*;
import com.cts.data.Class;
import com.cts.sheets.data.Column;
import com.cts.sheets.data.Table;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TableParser
{
    public static Teacher toTeacher(Table table)
    {
        // TODO: Add validation
        Teacher teacher = new Teacher();

        try
        {
            String id = table.getCols().get(1).getLabel();
            id = StringUtils.remove(id, " START");
            teacher.setId(id);
            teacher.setEmail(id);

            Class currentClass = null;
            DateFormat dateFormat = new SimpleDateFormat("HH:MM");

            for (Column column : table.getRows()) {
                String potentialTitle = getColumndData(column, 0);
                if (potentialTitle != null) {
                    currentClass = new Class();

                    Date startDate = dateFormat.parse(column.getC().get(1).getValue());
                    Date endDate = dateFormat.parse(column.getC().get(2).getValue());
                    currentClass.setTitle(potentialTitle);
                    currentClass.setStart(startDate);
                    currentClass.setEnd(endDate);

                    teacher.getClassList().add(currentClass);
                }

                String potentialStudent = getColumndData(column, 3);
                if (currentClass != null && potentialStudent != null && !potentialStudent.isEmpty())
                {
                    currentClass.getStudents().add(potentialStudent);
                }

            }
        }
        catch(Exception error)
        {
            throw new RuntimeException(error);
        }

        return teacher;
    }

    private static String getColumndData(Column column, int colData)
    {
        return column.getC().get(colData) != null ? column.getC().get(colData).getValue() : null;
    }

}


/*

https://docs.google.com/spreadsheets/d/15esEPiQ0jmjy5i0nduPXyfKYo1KsMzrhLy-O8mGynDg/edit#gid=2137398532

http://spreadsheets.google.com/tq?tq=select A,B,C,D&key=15esEPiQ0jmjy5i0nduPXyfKYo1KsMzrhLy-O8mGynDg


{
  "code" : 403,
  "errors" : [ {
    "domain" : "global",
    "message" : "The request is missing a valid API key.",
    "reason" : "forbidden"
  } ],
  "message" : "The request is missing a valid API key.",
  "status" : "PERMISSION_DENIED"
}


{
  "code" : 400,
  "errors" : [ {
    "domain" : "global",
    "message" : "API Key not found. Please pass a valid API key.",
Disconnected from the target VM, address: '127.0.0.1:56835', transport: 'socket'
    "reason" : "badRequest"
  } ],
  "message" : "API Key not found. Please pass a valid API key.",
  "status" : "INVALID_ARGUMENT"
}


{
   "version":"0.6",
   "reqId":"0",
   "status":"ok",
   "sig":"215539959",
   "table":{
      "cols":[
         {
            "id":"A",
            "label":"ID: CLASS",
            "type":"string"
         },
         {
            "id":"B",
            "label":"wedgwood.tom@gmail.com START",
            "type":"timeofday",
            "pattern":"h:mm am/pm"
         },
         {
            "id":"C",
            "label":"END",
            "type":"timeofday",
            "pattern":"h:mm am/pm"
         },
         {
            "id":"D",
            "label":"STUDENT",
            "type":"string"
         }
      ],
      "rows":[
         {
            "c":[
               {
                  "v":"Biology 100"
               },
               {
                  "v":[
                     9,
                     0,
                     0,
                     0
                  ],
                  "f":"9:00 AM"
               },
               {
                  "v":[
                     10,
                     0,
                     0,
                     0
                  ],
                  "f":"10:00 AM"
               },
               {
                  "v":"John K"
               }
            ]
         },
         {
            "c":[
               null,
               null,
               null,
               {
                  "v":"Bill P"
               }
            ]
         },
         {
            "c":[
               null,
               null,
               null,
               {
                  "v":"Ed S"
               }
            ]
         },
         {
            "c":[
               null,
               null,
               null,
               {
                  "v":"Sally M"
               }
            ]
         },
         {
            "c":[
               null,
               null,
               null,
               {
                  "v":"Edgar W"
               }
            ]
         },
         {
            "c":[
               {
                  "v":"Biology 115"
               },
               {
                  "v":[
                     10,
                     0,
                     0,
                     0
                  ],
                  "f":"10:00 AM"
               },
               {
                  "v":[
                     11,
                     0,
                     0,
                     0
                  ],
                  "f":"11:00 AM"
               },
               {
                  "v":"Karen Y"
               }
            ]
         },
         {
            "c":[
               null,
               null,
               null,
               {
                  "v":"Tom P"
               }
            ]
         },
         {
            "c":[
               null,
               null,
               null,
               {
                  "v":"Bill L"
               }
            ]
         }
      ]
   }
}

 */
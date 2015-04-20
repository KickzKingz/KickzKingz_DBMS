/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author Kent
 */
public class Event {
    
    private String _eventId, _location, _description, _name;
    
    private Date _date;
    
    private Time _time;
    
    public Event(String eventId, String location, String description,
            String name, Date date, Time time)
    {
        setEventId(eventId);
        setLocation(location);
        setDescription(description);
        setDate(date);
        setTime(time);
    }

    /**
     * @return the _eventId
     */
    private String getEventId() {
        return _eventId;
    }

    /**
     * @param _eventId the _eventId to set
     */
    private void setEventId(String _eventId) {
        this._eventId = _eventId;
    }

    /**
     * @return the _location
     */
    private String getLocation() {
        return _location;
    }

    /**
     * @param _location the _location to set
     */
    private void setLocation(String _location) {
        this._location = _location;
    }

    /**
     * @return the _description
     */
    private String getDescription() {
        return _description;
    }

    /**
     * @param _description the _description to set
     */
    private void setDescription(String _description) {
        this._description = _description;
    }

    /**
     * @return the _name
     */
    private String getName() {
        return _name;
    }

    /**
     * @param _name the _name to set
     */
    private void setName(String _name) {
        this._name = _name;
    }

    /**
     * @return the _date
     */
    private Date getDate() {
        return _date;
    }

    /**
     * @param date the _date to set
     */
    private void setDate(Date date) {
        this._date = date;
    }

    /**
     * @return the _time
     */
    private Time getTime() {
        return _time;
    }

    /**
     * @param time the _time to set
     */
    private void setTime(Time time) {
        this._time = time;
    }
    
}

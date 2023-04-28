package com.example.demo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Embeddable
public class ReservationId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "id_terrain", referencedColumnName = "idTerrain"),
        @JoinColumn(name = "nom_st", referencedColumnName = "nom")
    })
	private SousTerrain sousTerrain;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime time;

	public SousTerrain getSousTerrain() {
		return sousTerrain;
	}

	public void setSousTerrain(SousTerrain sousTerrain) {
		this.sousTerrain = sousTerrain;
	}


	public ReservationId(SousTerrain sousTerrain, LocalDate date, LocalTime time) {
		super();
		this.sousTerrain = sousTerrain;
		this.date = date;
		this.time = time;
	}


	public ReservationId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    ReservationId other = (ReservationId) obj;
	    if (date == null) {
	        if (other.date != null)
	            return false;
	    } else if (!date.equals(other.date))
	        return false;
	    if (sousTerrain == null) {
	        if (other.sousTerrain != null)
	            return false;
	    } else if (!sousTerrain.equals(other.sousTerrain))
	        return false;
	    if (time == null) {
	        if (other.time != null)
	            return false;
	    } else if (!time.equals(other.time))
	        return false;
	    return true;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((date == null) ? 0 : date.hashCode());
	    result = prime * result + ((sousTerrain == null) ? 0 : sousTerrain.hashCode());
	    result = prime * result + ((time == null) ? 0 : time.hashCode());
	    return result;
	}

}

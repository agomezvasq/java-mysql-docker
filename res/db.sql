-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema estudiantes
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema estudiantes
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `estudiantes` DEFAULT CHARACTER SET utf8 ;
USE `estudiantes` ;

-- -----------------------------------------------------
-- Table `estudiantes`.`Carrera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudiantes`.`Carrera` (
  `idCarrera` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCarrera`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudiantes`.`Estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudiantes`.`Estudiante` (
  `idEstudiante` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `documento` VARCHAR(45) NOT NULL,
  `codigo` VARCHAR(45) NULL,
  `telefono` VARCHAR(7) NOT NULL,
  `celular` VARCHAR(10) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `Carrera_idCarrera` INT NOT NULL,
  PRIMARY KEY (`idEstudiante`),
  INDEX `fk_Estudiante_Carrera_idx` (`Carrera_idCarrera` ASC),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC),
  UNIQUE INDEX `documento_UNIQUE` (`documento` ASC),
  CONSTRAINT `fk_Estudiante_Carrera`
    FOREIGN KEY (`Carrera_idCarrera`)
    REFERENCES `estudiantes`.`Carrera` (`idCarrera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
